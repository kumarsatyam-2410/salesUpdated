package com.omc.sales.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.omc.sales.service.UserService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter {

//	@Bean
//	public UserDetailsServiceImpl userDetailsServiceImpl(){
//		return new UserDetailsServiceImpl();
//	}
//
//	@Bean
//	public NoOpPasswordEncoder passwordEncoder(){
//		return new NoOpPasswordEncoder();
//	}
	
	@Autowired
	private UserService userService;

	@Bean
	public DaoAuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		authenticationProvider.setUserDetailsService(userService);
		return authenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	/**
	 *   ADMIN - gyan , nisar  - ALL
	 *   USER  - ankit - only GET
	 *   EDITOR - prashant - only POST
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.cors();
		http.authorizeRequests()
		//.antMatchers("/swagger*/**").hasRole("swagger")
		.antMatchers("/swagger*/**").authenticated()
		//.antMatchers("/rms/user/**").authenticated()
		.antMatchers("/rms*/**").authenticated()
		.anyRequest().permitAll()
		.and()
		.csrf().disable()
		.httpBasic();
	}

}