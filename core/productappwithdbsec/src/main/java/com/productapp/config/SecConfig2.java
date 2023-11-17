//package com.productapp.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.stereotype.Component;
//@Component
//@EnableWebSecurity(debug = true)
////hey spring i want to go for method level sec
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
//public class SecConfig2{
//
//	//who are you -> 401: Authentation
//	@Autowired
//	private UserDetailsService detailsService;
//	
//	//alternative: u can define a method that return a bean of AuthenticationProvider
//	@Bean
//	public AuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
//		authenticationProvider.setUserDetailsService(detailsService);
//		authenticationProvider.setPasswordEncoder(encoder());
//		return authenticationProvider;
//	}
//	
//
//	@Bean
//	public PasswordEncoder encoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	//I know who are u let me check if u can access this resouces -> 403
//	@Bean
//	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		return  http.csrf().disable()
//          .authorizeRequests().anyRequest().authenticated()
////          .antMatchers("/admin/**").hasAnyRole("ADMIN")
////          .antMatchers("/mgr/**").hasAnyRole("ADMIN","MGR")
////          .antMatchers("/home/**").permitAll()
//          .and()
//          .httpBasic()
//          .and()
//          .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//          .and()
//          .build();
//	}
//
//}
//
//
