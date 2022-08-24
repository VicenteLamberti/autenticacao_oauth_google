package br.com.estudo.seguranca.oauth.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 http.authorizeRequests()
         .antMatchers("/**").fullyAuthenticated()
         .and()
         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
         .and()
         .oauth2ResourceServer().jwt()
         .and()
         .and()
         .cors().and().csrf().disable();
		  
		  return http.build();
    }
	
	@Bean
	public JwtDecoder decoder() {
		return new JwtDecoder() {
			
			@Override
			public Jwt decode(String token) throws JwtException {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
	

}
