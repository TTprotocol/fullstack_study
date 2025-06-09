package org.exam2.app;

import org.exam2.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main3 {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(ProjectConfig.class);
    }
}
