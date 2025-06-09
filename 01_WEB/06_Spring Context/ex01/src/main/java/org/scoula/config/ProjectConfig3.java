package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// 지정된 패키지를 스캔해서 @Component가 붙은 클래스를 빈으로 등록
@ComponentScan(basePackages = "org.scoula.domain")
public class ProjectConfig3 {
}
