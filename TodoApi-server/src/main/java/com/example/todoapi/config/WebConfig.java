package com.example.todoapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // すべてのエンドポイント
                .allowedOrigins("http://192.168.56.101")  // 許可するオリジンを指定
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 許可するメソッドを指定
                .allowedHeaders("*");  // 許可するヘッダを指定
    }
}