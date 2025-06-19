package com.example.demo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class CorsConfigs {
	 @Bean
	  public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	      @Override
	      public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")           // allow all paths
	                .allowedOrigins("*")          // allow all origins
	                .allowedMethods("*")          // allow all HTTP methods (GET, POST, etc)
	                .allowedHeaders("*")          // allow all headers
	                .allowCredentials(false);    // true if you want cookies/auth, but with * origins it's false
	      }
	    };
	  }
}
