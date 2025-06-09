package org.scoula.app;

import org.scoula.config.ProjectConfig;
import org.scoula.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 스프링 컨텍스트 생성
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // 해당 타입의 bean을 context에서 꺼내온다. (타입으로 가져오고 있다.)
        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());

        Parrot p2 = context.getBean(Parrot.class);
        System.out.println(p2.getName());

        // p와 p2는 동일한 객체이다. = 싱글톤 패턴
        System.out.println(p == p2);    // true

        // 동일한 타입은 하나의 빈만 추출 가능
        // 동일한 타입이 여러개 있는 경우 예외 발생 => 빈 이름을 추가
        String s = context.getBean(String.class);
        System.out.println(s);

        Integer n = context.getBean(Integer.class);
        System.out.println(n);

    }
}
