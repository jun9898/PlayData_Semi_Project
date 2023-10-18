package com.example.project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Value("${RESOURCE_REQUEST_PATH}")
    private String RESOURCE_REQUEST_PATH;

    @Value("${RESOURCE_REAL_PATH}")
    private String RESOURCE_REAL_PATH;

    //정적리소스의 경로를 설정하는 경우 사용
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //특정 path로 요청하는 경우 실제 파일이 저장된 위치를 연결해서 리소스를 가져올 수 있도록 처리
        registry.addResourceHandler(RESOURCE_REQUEST_PATH)     // /download/**
                .addResourceLocations(RESOURCE_REAL_PATH); // file:///C:/javaweb/upload/
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/content/feed", "/login", "/join", "/forget", "/content/map", "/content/rank",
//                        인터셉터 사용시 CSS와 JS 파일도 권한을 줘야 작동한다 (놀라운 사실)
                        "/css/**", "/asset/**", "/js/**"
//                        exam
//                        "/board/ajax/list.do", "/images/**"
//                        , "/common/css/**", "/emp/logout.do", "/emp/spring/logout"
                );

    }
}
