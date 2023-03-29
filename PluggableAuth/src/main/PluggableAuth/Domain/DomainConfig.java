package com.Group25.PluggableAuth.Domain;

import com.Group25.PluggableAuth.Adapters.outbound.SendMail.SendMailDemo;
import com.Group25.PluggableAuth.Port.EmailPort;
import com.Group25.PluggableAuth.Domain.JwtService;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.ECDSASigner;
import com.nimbusds.jose.crypto.ECDSAVerifier;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.jwk.JWK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

import java.text.ParseException;
import java.time.LocalDateTime;

import static com.nimbusds.jose.JWSAlgorithm.ES384;

@Configuration
public class DomainConfig {
    //  @Value("${json key?}")
    //  private String key;

//   @Value("${sender}")
    //  private String sender;

    @Autowired
    public EmailPort mailPort;

    @Bean
    public LoginService loginService(JwtService jwtService, String message) {
        return new LoginService(mailPort, jwtService, message);
    }

    @Bean
    public SimpleMailMessage simpleMailMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("me@gmail.comma");
        message.setSubject("subject");
        message.setText("Token: %s \n Link: %s");
        return message;
    }

    @Bean
    public ECKey ecJWK() {
        //    return (ECKey) JWK.parse(json key);
        return null;
    }

    //build the header, using the jwt using key
    @Bean
    public JWSHeader jwsHeader(ECKey ecJWK) {
        return new JWSHeader.Builder(JWSAlgorithm.ES256).keyID(ecJWK.getKeyID()).build();
    }

    @Bean
    public JWSSigner jwsSigner(ECKey ecJWK) {
        try {
            return new ECDSASigner(ecJWK);
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }

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