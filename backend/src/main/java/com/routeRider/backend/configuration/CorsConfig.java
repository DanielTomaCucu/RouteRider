package com.routeRider.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Development environments
        config.addAllowedOrigin("http://localhost:8100");
        config.addAllowedOrigin("http://localhost:4200");

        // Production environments - add your actual domain
        config.addAllowedOrigin("https://yourappdomain.com");

        // Or for testing, you might want to allow requests from any origin
        // config.addAllowedOrigin("*");  // Be careful with this in production

        // Allow common HTTP methods
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("OPTIONS");

        // Allow all headers
        config.addAllowedHeader("*");

        // Allow credentials if your app uses cookies or authentication
        config.setAllowCredentials(true);

        // How long the browser should cache the CORS response (in seconds)
        config.setMaxAge(3600L);

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
