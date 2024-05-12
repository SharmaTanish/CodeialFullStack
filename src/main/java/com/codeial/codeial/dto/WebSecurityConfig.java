package com.codeial.codeial.dto;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.RSAKey;


@Configuration
public class WebSecurityConfig {

    //@Autowired
    //private JwtAuthenticationEntryPoint point;
    //@Autowired
    //private JwtAuthenticationFilter filter;
    

    @SuppressWarnings("deprecation")
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	
    	http.cors().disable();
    	 
    	http.csrf().disable();
     
	   http.authorizeHttpRequests(request -> 
		   request.anyRequest().authenticated()
		);
	    
	    http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    	
	    http.httpBasic();
        
	   // http.exceptionHandling(ex -> ex.authenticationEntryPoint(point)); //configuring custom entry point "entry" for handling exception
            
	   http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
	    
    	return http.build();
    }
    
    @Bean
    public KeyPair keyPair() {
    	try {
    		var keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    		keyPairGenerator.initialize(2048);
    		return keyPairGenerator.generateKeyPair();
    				
    	}
    	catch (Exception e) {
			throw new RuntimeException(e);// TODO: handle exception
		}
    }
    
    @Bean
    public RSAKey rsaKey(KeyPair keyPair) {
    	return new RSAKey
    			.Builder((RSAPublicKey)keyPair.getPublic())
    			.privateKey((RSAPrivateKey)keyPair.getPrivate())
    			.keyID(UUID.randomUUID().toString())
    			.build();
    }
    
}




