package org.scoula.app;

import org.scoula.config.ProjectConfig;
import org.scoula.config.ProjectConfig2;
import org.scoula.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig2.class);

        // 동일한 Parrot 타입이 여러개 있으므로 예외가 발생한다!
        // NoUniqueBeanDefinitionException
//        Parrot p = context.getBean(Parrot.class);
//        System.out.println(p.getName());

        // 이름이 중복되지 않도록 지정하여 추출 가능
        Parrot p = context.getBean("miki", Parrot.class);
        System.out.println(p.getName());
    }
}
