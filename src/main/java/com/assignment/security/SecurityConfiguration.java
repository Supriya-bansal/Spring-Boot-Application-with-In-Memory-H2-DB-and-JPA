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
		.withUser(Roles.TECHLEAD.name()).password("{noop}TECHLEAD").roles(Roles.TECHLEAD.name())
		.and().withUser(Roles.ADMIN.name()).password("{noop}ADMIN").roles(Roles.TECHLEAD.name(), Roles.ADMIN.name());
	}

	/* This is for Authorization :: Define which role has what access*/
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests()
		.antMatchers("/members/**").hasRole(Roles.TECHLEAD.name())
		.antMatchers("/**").hasRole(Roles.ADMIN.name())
		.and().csrf().disable().headers().frameOptions().disable();
	}

}
