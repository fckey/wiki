package com.fangshaolei.wiki.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author fangshaolei
 * @version 1.0.0
 * @ClassName SpringMvcConfig
 * @Description
 * @createTime 2022/06/09 20:09
 **/
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

//    @Resource
//    private LogInterceptor logInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(logInterceptor)
//                .addPathPatterns("/**").excludePathPatterns("/login");
//    }
}
