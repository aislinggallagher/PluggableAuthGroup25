package com.Group25.PluggableAuth.Domain;
import com.nimbusds.jose.*;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

//import java.security.SecureRandom;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class JwtService {

    private JWSHeader jwsHeader;
    private JWSSigner jwssigner;

    public JwtService(JWSHeader jwsHeader, JWSSigner jwssigner)
    {
        this.jwsHeader = jwsHeader;
        this.jwssigner = jwssigner;
    }

    public String generateJWT(String email, String website) throws JOSEException
    {

        Instant now = Instant.now();
        Instant expires = now.plus(3, ChronoUnit.HOURS);

        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .issuer(website)
                .subject(email)
                .notBeforeTime(Date.from(now))
                .expirationTime(Date.from(expires))
                .build();

        SignedJWT signedJWT = new SignedJWT(jwsHeader, claimsSet);
        signedJWT.sign(jwssigner);

        String serializedJWT = signedJWT.serialize();
        return serializedJWT;
    }

    /*
    public static String secretKeyGenerator(int bits)
    {
    	SecureRandom random = new SecureRandom();
        byte[] keyBytes = new byte[bits];
        random.nextBytes(keyBytes);
        String secretKey = new String(keyBytes);
        return secretKey;
    }
    */
}
