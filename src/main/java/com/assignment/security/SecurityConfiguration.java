package com.assignment.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	/* This is for Authentication :: Configuring Access credentials for different roles*/
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication()
		.withUser("USER").password("{noop}USER").roles("USER")
		.and().withUser("TECHLEAD").password("{noop}	").roles("TECHLEAD")
		.and().withUser("ADMIN").password("{noop}ADMIN").roles("USER","TECHLEAD", "ADMIN");
	}

	/* This is for Authorization :: Define which role has what access*/
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests()
		.antMatchers("/members/**").hasRole("USER")
		.antMatchers("/**").hasRole("TECHLEAD")
		.antMatchers("/**").hasRole("ADMIN")
		.and().csrf().disable().headers().frameOptions().disable();
	}

}
