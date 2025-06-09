package org.exam.app;

import org.exam.config.ProjectConfig;
import org.exam.domain.Dog;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Dog d1 = context.getBean("꼬미", Dog.class);
        Dog d2 = context.getBean("밤비", Dog.class);
        Dog d3 = context.getBean("해피", Dog.class);

        System.out.println("[1]등록된 강아지 목록 : ");
        System.out.println("[Dog] 이름 : " + d1.getName() + ", 견종 : " + d1.getBreed());
        System.out.println("[Dog] 이름 : " + d2.getName() + ", 견종 : " + d2.getBreed());
        System.out.println("[Dog] 이름 : " + d3.getName() + ", 견종 : " + d3.getBreed());
    }
}
