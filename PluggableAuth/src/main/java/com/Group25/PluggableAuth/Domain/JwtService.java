package com.Group25.PluggableAuth.Domain;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;



import java.security.SecureRandom;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class JwtService {
    
    public static String generateJWT(String email, String website, String secretKey) throws JOSEException {

        Instant now = Instant.now();
        Instant expires = now.plus(3, ChronoUnit.HOURS);

        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .issuer(website)
                .subject(email)
                .notBeforeTime(Date.from(now))
                .expirationTime(Date.from(expires))
                .build();
        JWSObject jwsObject = new JWSObject(new JWSHeader(JWSAlgorithm.HS256), new Payload(claimsSet.toJSONObject()));

        JWSSigner signer = new MACSigner(secretKey);
        jwsObject.sign(signer);

        String serializedJWT = jwsObject.serialize();        
        return serializedJWT;
    }
    
    public static String secretKeyGenerator(int bits)
    {
    	SecureRandom random = new SecureRandom();
        byte[] keyBytes = new byte[bits];
        random.nextBytes(keyBytes);
        String secretKey = new String(keyBytes);
        return secretKey;
    }
}