package com.example.demo.adapter.imageservice;

import feign.RequestInterceptor;
import feign.okhttp.OkHttpClient;
import org.apache.http.entity.ContentType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImageServiceConfiguration {
    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }
}
