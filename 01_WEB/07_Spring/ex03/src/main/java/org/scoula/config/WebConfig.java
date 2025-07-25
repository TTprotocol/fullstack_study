package org.scoula.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

@Slf4j
@Configuration
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    final String LOCATION = "c:/upload";    // 업로드 위치
    final long MAX_FILE_SIZE = 1024 * 1024 * 10L; // 파일 하나당 최대 크기 : 10M
    final long MAX_REQUEST_SIZE = 1024 * 1024 * 20L; // 한 번 요청에 업로드하는 최대 크기 : 20M
    final int FILE_SIZE_THRESHOLD = 1024 * 1024 * 5; // 파일이 메모리에서 처리될 수 있는 최대 크기 : 5M => 5M보다 크면 임시 파일(temp)에서 처리된다.

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfig.class};
    }

    // 스프링의 FrontController인 DispatcherServlet이 담당할 Url 매핑 패턴, / : 모든 요청에 대해 매핑 @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // POST body 문자 인코딩 필터 설정 - UTF-8 설정
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[]{characterEncodingFilter};
    }


    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        // 404 에러 처리를 위한 코드
        // 핸들러가 없을 때 예외가 발생하도록 처리함
        // 존재하지 않는 URL 요청시 404 응답이 아닌 예외 발생시킴
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");

        MultipartConfigElement multipartConfig = new MultipartConfigElement(
            LOCATION, // 업로드 처리 디렉토리 경로
            MAX_FILE_SIZE, // 업로드 가능한 파일 하나의 최대 크기
            MAX_REQUEST_SIZE, // 업로드 가능한 전체 최대 크기(여러 파일 업로드 하는 경우)
            FILE_SIZE_THRESHOLD // 메모리 파일의 최대 크기(이보다 작으면 실제 메모리에서만 작업)
        );

        registration.setMultipartConfig(multipartConfig);
    }
}
