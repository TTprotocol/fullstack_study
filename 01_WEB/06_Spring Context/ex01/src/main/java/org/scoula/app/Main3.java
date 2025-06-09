package org.scoula.app;

import org.scoula.config.ProjectConfig2;
import org.scoula.config.ProjectConfig3;
import org.scoula.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main3 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig3.class);

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p);
        // 생성된 객체는 등록됐지만, 초기화 작업이 되지 않았다 -> null
        // 초기화 작업을 위한 어노테이션 : @PostConstruct
        System.out.println(p.getName());
    }
}
