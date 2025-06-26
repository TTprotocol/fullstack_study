package org.scoula.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Log4j2
@Configuration
@EnableWebSecurity  // Spring Security 활성화
@MapperScan(basePackages = {"org.scoula.security.account.mapper"})
@ComponentScan(basePackages = {"org.scoula.security"})
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // userDetailsService를 주입받음
    // DB 기반 인증 처리를 위한 서비스 (in-memory 방식과 병행 불가)
    private final UserDetailsService userDetailsService;

    // 문자셋 필터 정의
    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();

        encodingFilter.setEncoding("UTF-8");    // UTF-8로 문자셋 정의
        encodingFilter.setForceEncoding(true);  // 강제설정

        return encodingFilter;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // SCRF 필터보다 먼저 문자셋 필터를 세팅함
        http.addFilterBefore(encodingFilter(), CsrfFilter.class);

        // 경로별 접근 권한 설정
        http.authorizeRequests()
            .antMatchers("/security/all").permitAll()   // 모든 사용자 접근 허용
            .antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')") // ADMIN 권한 보유자만 허용
            .antMatchers("/security/member").access("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')"); // MEMBER, ADMIN 권한 보유자만 허용

        http.formLogin()    // form 기반 로그인 설정 시작
            .loginPage("/security/login")   // 커스텀 로그인 페이지의 경로 설정 (GET 요청)
            .loginProcessingUrl("/security/login")  // 로그인 처리를 위한 경로 설정 (POST 요청)
            .defaultSuccessUrl("/");    // 성공시 리다이렉트될 기본 URL 설정

        http.logout()   // 로그아웃 설정 시작
            .logoutUrl("/security/logout")  // post 로그아웃 호출 URL
            .invalidateHttpSession(true)    // 세션 invalidate
            .deleteCookies("remember-me", "JSESSION-ID")    // 삭제할 쿠키 목록
            .logoutSuccessUrl("/security/logout");  // get. 로그아웃 이후에 이동할 URL

        http.formLogin(); // form 기반 로그인 활성화, 나머지는 모두 디폴트
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
        throws Exception {
        log.info("configure .........................................");

        // 관리자 계정 설정
//        auth.inMemoryAuthentication()
//            .withUser("admin")
////            .password("{noop}1234") // 평문 비밀번호 (비권장)
//            .password("$2a$10$VJK.3K/W3PhSu53.FVm7WOEzFZPlGTw5.iiCZXgKTHPkhK419Jdz2") // 암호화
//            .roles("ADMIN", "MEMBER"); // ROLE_ADMIN  // 관리자이자 회원 ("ADMIN", "MEMBER")
        
         // 일반 사용자 계정 설정
//        auth.inMemoryAuthentication()
//            .withUser("member")
////            .password("{noop}1234") // 평문 비밀번호
//            .password("$2a$10$VJK.3K/W3PhSu53.FVm7WOEzFZPlGTw5.iiCZXgKTHPkhK419Jdz2") // 암호화
//            .roles("MEMBER"); // ROLE_MEMBER  // 회원 권한만 부여

        // DB에서 사용자 정보를 조회하고, 해시된 비밀번호로 인증
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
    }

    // 보안 강화를 위한 BCrypt 해시 알고리즘 사용
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
