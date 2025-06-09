package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc   // Spring MVC 기능 활성화
@ComponentScan(basePackages = {"org.scoula.controller"})
public class ServletConfig implements WebMvcConfigurer {
    // 정적 자원 처리 설정 (CSS, JS, 이미지 등)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
            .addResourceHandler("/resources/**") // url이 /resources/로 시작하는 모든 경로      // 요청 url 등록
            .addResourceLocations("/resources/"); // webapp/resources/경로로 매핑                        // 실제 리소스 위치
    }

    // jsp view resolver 설정
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();

        bean.setViewClass(JstlView.class);  // JSTL 지원 뷰
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");

        registry.viewResolver(bean);    // 등록
    }


}
