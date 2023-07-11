package com.sunpower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SunPowerApplication {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry
                        .addMapping("/**")
                        .allowedOrigins("*","")
                        .allowedHeaders("*")
                        .allowedMethods("POST","GET","PUT","PATCH","OPTIONS");
            }
        };
    }
	public static void main(String[] args) {
		SpringApplication.run(SunPowerApplication.class, args);
	}

}
