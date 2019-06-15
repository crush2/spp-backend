package com.example.spp_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SppBackendApplication {

//    @Bean
//    @Order(Integer.MAX_VALUE)
//    public CorsFilter corsFilter() {
//        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        final CorsConfiguration corsConfiguration = new CorsConfiguration(); corsConfiguration.setAllowCredentials(true);
//        // 设置你要允许的网站域名，如果全允许则设为 *
//        corsConfiguration.addAllowedOrigin("*");
//        // 如果要限制 HEADER 或 METHOD 请自行更改 corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedMethod("*");
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//        return new CorsFilter();
//    }

    public static void main(String[] args) {
        SpringApplication.run(SppBackendApplication.class, args);
    }

}
