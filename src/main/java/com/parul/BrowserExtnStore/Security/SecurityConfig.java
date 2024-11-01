package com.parul.BrowserExtnStore.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/store", "/login", "/css/**", "/js/**", "/images/**").permitAll()   // Allow these paths without login
                .anyRequest().authenticated()                       // Secure all other paths
            )
            .oauth2Login(oauth2 -> oauth2
                .loginPage("http://localhost:8080/login/oauth2/code/google")     // Custom OAuth2 login page if needed
                .defaultSuccessUrl("/store", true)                   // Redirect to home after login
            );

        return http.build();
    }
    
    @Bean
    public CorsFilter corsFilter() {
    	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    	CorsConfiguration config = new CorsConfiguration();  //allow oauth2 token with browser for every incoming request 
    	config.addAllowedOriginPattern("https://lh3.googleusercontent.com");
    	config.addAllowedHeader("*");
    	config.addAllowedMethod("*");
    	source.registerCorsConfiguration("/**", config);
    	return new CorsFilter(source);
    	
    }
}

