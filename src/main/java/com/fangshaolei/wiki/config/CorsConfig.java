package com.fangshaolei.wiki.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author fangshaolei
 * @version 1.0.0
 * @ClassName CorsConfig
 * @Description 解决跨域问题
 * @createTime 2022/06/08 20:48
 **/
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedHeaders(CorsConfiguration.ALL)
                .allowedMethods(CorsConfiguration.ALL)
                .allowCredentials(true)  // 允许带上验证信息
                .maxAge(3600); // 1小时内不需要再次预检（发送options请求）
    }
}
