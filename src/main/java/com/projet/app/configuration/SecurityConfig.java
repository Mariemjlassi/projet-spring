package com.projet.app.configuration;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.projet.app.filters.JwtRequestFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	private final JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	public SecurityConfig(JwtRequestFilter jwtRequestFilter) {
		super();
		this.jwtRequestFilter = jwtRequestFilter;
	}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        return security.csrf(csrf->csrf.disable())
                .authorizeHttpRequests()
                .requestMatchers("/sendmail").authenticated()
                .requestMatchers("/arrondissements/**").authenticated()
                .requestMatchers("/zones/**").authenticated()
                .requestMatchers("/rues/**").authenticated()
                .requestMatchers("/proprietaire/**").authenticated()
                .requestMatchers("/terrainnb/**").authenticated()
                .requestMatchers("/signup", "/login").permitAll()
                .requestMatchers("/densite/**").authenticated()
                .requestMatchers("/terrain/**", "/taxe/calcul").authenticated()
                .and()
                .authorizeHttpRequests()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}
