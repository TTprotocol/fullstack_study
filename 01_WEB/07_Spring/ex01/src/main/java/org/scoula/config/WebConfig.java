package org.scoula.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    // 루트 어플리케이션 설정 (서비스, DAO, DB 등)
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    // 서블릿 어플리케이션 설정 (Controller, ViewResolver 등)
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfig.class};
    }

    // 스프링의 FrontController 인 DispatcherServlet 이 담당할 Url 매핑 패턴, / : 모든 요청에 대해 매핑
    // DispatcherServlet 의 URL 매핑
    @Override
    protected String[] getServletMappings() {
        // 모든 요청을 DispatcherServlet 이 처리
        return new String[]{"/"};
    }

    // POST body 문자 인코딩 필터 설정 - UTF-8 설정
    // 한글 Post 요청 인코딩 필터 설정
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true); // 강제 인코딩 설정
        
        return new Filter[]{characterEncodingFilter};
    }
}
