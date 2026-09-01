package com.security.autenticacao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean 
	public SecurityFilterChain securityFilterChain(HttpSecurity http)
	throws Exception {
		http 
			.authorizeHttpRequests(auth -> auth
			.requestMatchers("/publico").permitAll()
			.requestMatchers("/admin").hasRole("ADMIN")
			.requestMatchers("/produtos").authenticated()
			.anyRequest().authenticated()
		)
		.httpBasic(Customizer.withDefaults());
		return http.build(); 
	}

	@Bean 
	public InMemoryUserDetailsManager usuarios() { 

		UserDetails usuario = User
				.withUsername("aluno")
				.password("{noop}123")
				.roles("USER")
				.build();

		UserDetails administrador = User
				.withUsername("admin")
				.password("{noop}123")
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(
				usuario,
				administrador
		);
	}
}
