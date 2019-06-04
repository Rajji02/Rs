package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


	   @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	     /*   auth.inMemoryAuthentication()
	                .withUser("ajay").password("{noop}test").roles("USER").and()
	                .withUser("demo").password("{noop}test2").roles("ADMIN");*/
		   
			auth.inMemoryAuthentication()
			.passwordEncoder(NoOpPasswordEncoder.getInstance())
			.withUser("user").password("password").roles("USER");
	      	    }
	  /*
	   * 
	   
	    
	     @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()
                .authorizeRequests()
                .requestMatchers(EndpointRequest.to("info", "health")).permitAll()
                .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("SYSTEM")
                .antMatchers("/**").hasRole("USER");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("password")
                .roles("USER")
                .and()
                .withUser("sysuser")
                .password("password")
                .roles("SYSTEM");
    }
	   */
	
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

    	
        httpSecurity
        .authorizeRequests()
        .anyRequest()
        .fullyAuthenticated()
        //.antMatchers("**/rest/*")
        .and()
        //.addFilterBefore(customFilter(), BasicAuthenticationFilter.class)
        .httpBasic();
httpSecurity.csrf().disable();

    }


    
}
