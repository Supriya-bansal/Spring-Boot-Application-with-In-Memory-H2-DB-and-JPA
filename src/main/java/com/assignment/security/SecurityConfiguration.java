package com.assignment.security;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;


@Configuration	
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	/* This is for Authentication :: Configuring Access credentials for different roles*/
	
	  @Override protected void configure(AuthenticationManagerBuilder auth) throws
	Exception {
		
		  auth.inMemoryAuthentication()
		  .withUser(Roles.TECHLEAD.name()).password("{noop}TECHLEAD").roles(Roles.
		  TECHLEAD.name())
		  .and().withUser(Roles.ADMIN.name()).password("{noop}ADMIN").roles(Roles.
		  TECHLEAD.name(), Roles.ADMIN.name());
		  }
	 

	/* This is for Authorization :: Define which role has what access*/
	
	 
	@Override
	   protected void configure(HttpSecurity http) throws Exception {
		System.out.println("backend application is now being called");
		
		  http.httpBasic().and().authorizeRequests()
		  .antMatchers("/members/**").hasRole(Roles.TECHLEAD.name())
		  .antMatchers("/**").hasRole(Roles.ADMIN.name())
		  .and().csrf().disable().headers().frameOptions().disable();
		 
		//http.authorizeRequests().antMatchers("/").permitAll();

	       http.cors().configurationSource(new CorsConfigurationSource() {

	        @Override
	        public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
	            CorsConfiguration config = new CorsConfiguration();
	            config.setAllowedHeaders(Collections.singletonList("*"));
	            config.setAllowedMethods(Collections.singletonList("*"));
	            config.addAllowedOrigin("*");
	            config.setAllowCredentials(true);
	            return config;
	        }
	      });


	   }
}
