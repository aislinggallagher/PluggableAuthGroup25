package com.Group25.PluggableAuth.Domain;

import com.Group25.PluggableAuth.Port.EmailPort;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.ECDSASigner;
import com.nimbusds.jose.crypto.ECDSAVerifier;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.jwk.JWK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;


@Configuration
public class DomainConfig {
    @Value("${jwk}")
    private String key;

    @Autowired(required = true)
    public EmailPort mailPort;

    @Bean
    public LoginService loginService(JwtService jwtService, String message) {
        return new LoginService(mailPort,jwtService, message);
    }

    @Bean
    public ECKey ecJWK() {
        try {
            return (ECKey) JWK.parse(key);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    //build the header, using key
    @Bean
    public JWSHeader jwsHeader(ECKey ecJWK) {
        return new JWSHeader.Builder(JWSAlgorithm.ES256).keyID(ecJWK.getKeyID()).build();
    }

    //sign it
    @Bean
    public JWSSigner jwsSigner(ECKey ecJWK) {
        try {
            return new ECDSASigner(ecJWK);
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }

    //then verify it
    @Bean
    public JWSVerifier jwsVerifier(ECKey ecJWK) {
        try {
            return new ECDSAVerifier(ecJWK.toPublicJWK());
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public JwtService jwtService(JWSHeader jwsHeader, JWSSigner jwsSigner) {
        return new JwtService(jwsHeader, jwsSigner);
    }
}
