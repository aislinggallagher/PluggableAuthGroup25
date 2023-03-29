package com.Group25.PluggableAuth.Adapters.inbound.SecureLayer;

import java.io.IOException;
import java.text.ParseException;


import jakarta.servlet.ServletException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtValidation extends OncePerRequestFilter{
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtValidation.class);
    private final JWSVerifier jwsVerifier;

    public JwtValidation(JWSVerifier jwsVerifier)
    {
        this.jwsVerifier = jwsVerifier;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException
    {

        LOGGER.info("Received request: {} {}", request.getMethod(), request.getRequestURI());

        String token = request.getParameter("token");
        if (token == null)
        {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token is missing");
            return;
        }

        try
        {
            SignedJWT signedJWT = SignedJWT.parse(token);
            LOGGER.info("Token subject: {}", signedJWT.getJWTClaimsSet().getSubject());
            LOGGER.info("Token issuer: {}", signedJWT.getJWTClaimsSet().getIssuer());
            LOGGER.info("Token issued at: {}", signedJWT.getJWTClaimsSet().getIssueTime());
            LOGGER.info("Token expires at: {}", signedJWT.getJWTClaimsSet().getExpirationTime());
            if (signedJWT.verify(jwsVerifier))
            {
                filterChain.doFilter(request, response);
                LOGGER.info("Processed request successfully");
            }
            else
            {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token signature is invalid");
            }

        }
        catch (ParseException | JOSEException e)
        {
            LOGGER.warn("Token validation exception: {}", e.getMessage());
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token is invalid");
        }
    }

}

// so everything here checks out for the most part...however
// the secret keys will be created in the domain configuration
// so thats something we'll have to deal with later, i presume.
// overall though, well played