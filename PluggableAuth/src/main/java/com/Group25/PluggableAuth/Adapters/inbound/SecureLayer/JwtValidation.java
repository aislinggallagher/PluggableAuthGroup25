package com.Group25.PluggableAuth.Adapters.inbound.SecureLayer;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.web.filter.OncePerRequestFilter;

//public class JwtValidation extends OncePerRequestFilter {
public class JwtValidation extends OncePerRequestFilter{
    private static final Logger logger = LoggerFactory.getLogger(JwtValidation.class);
//    private final JWSVerifier jwsVerifier;
//
//    public JwtValidation(JWSVerifier jwsVerifier) {
//        this.jwsVerifier = jwsVerifier;
//    }


    public static boolean validateJWT(HttpServletRequest request, String secret) {
        try {
            // Extract the JWT from the "Authorization" header
            String authHeader = request.getHeader("Authorization");
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                logger.warn("JWT not found in Authorization header");
                return false;
            }
            String jwtString = authHeader.substring(7);

            // Parse and verify the JWT
            SignedJWT jwt = SignedJWT.parse(jwtString);
            JWSSigner signer = new MACSigner(secret.getBytes());
            JWSVerifier verifier = new MACVerifier(secret.getBytes());
            boolean isValid = jwt.verify(verifier);

            if (!isValid) {
                logger.warn("JWT verification failed");
            }

            return isValid;

        } catch (ParseException e) {
            logger.warn("Error parsing JWT: {}", e.getMessage());
            return false;

        } catch (Exception e) {
            logger.error("Error validating JWT: {}", e.getMessage());
            return false;
        }
    }

    @Override
    protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request,
                                    jakarta.servlet.http.HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        final String header = request.getHeader("Authorization");
        if ((header) == null || !header.startsWith("Bearer ")) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "The token cant be found");
//        } else if (!validateJWT(request)) {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token is not authorized");
//        }
            filterChain.doFilter(request, response);

        }

    }
}

// so everything here checks out for the most part...however
// the secret keys will be created in the domain configuration
// so thats something we'll have to deal with later, i presume.
// overall though, well played