package com.itemmaster.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class WebConfig {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");

			}
		};
	}

	// .access("hasAnyRole('ADMIN', 'USER')");

	// For ADMIN only.
	// http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().and()
//				// starts authorizing configurations
//				.authorizeRequests()
//				// ignoring the guest's urls "
//				.antMatchers("/account/register", "/account/login", "/logout").permitAll()
//				// authenticate all remaining URLS
//
//				.anyRequest().fullyAuthenticated().and()
//				/*
//				 * "/logout" will log the user out by invalidating the HTTP Session, cleaning up
//				 * any {link rememberMe()} authentication that was configured,
//				 */
//				.logout().permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST")).and()
//				// enabling the basic authentication
//				.httpBasic().and()
//				// configuring the session on the server
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).and()
//				// disabling the CSRF - Cross Site Request Forgery
//				.csrf().disable();
//	}

}
