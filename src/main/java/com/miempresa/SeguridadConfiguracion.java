package com.miempresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.miempresa.service.UsuarioServicio;

@Configuration
@EnableWebSecurity
public class SeguridadConfiguracion {
	@Autowired
	private UsuarioServicio userDet;
	

	@Autowired
	private BCryptPasswordEncoder bcryp;
	
	@Bean
	public BCryptPasswordEncoder passEncoder() {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		return bcpe;
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDet).passwordEncoder(bcryp);
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf().disable()
	        .authorizeHttpRequests(authorize -> 
	            authorize
	                .requestMatchers("/carrito").hasRole("ADMIN")
	                .requestMatchers("/", "/categoria").hasAnyRole("USER", "ADMIN")
	                .anyRequest().authenticated()
	        )
	        .formLogin()
	            .loginPage("/login") // Especifica la URL de la página de inicio de sesión personalizada
	            .permitAll()
	        .and()
	        .logout()
	        .permitAll()
	        .and()
	        .exceptionHandling()
	            .accessDeniedPage("/error"); // Redirige a la página de error personalizada
	    return http.build();
	}




}
