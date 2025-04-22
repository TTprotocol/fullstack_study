package ch09.sec02.exam02;

public class A {
    class B {
        int field1 = 1;
        
        // Java 17부터 static 가능
        static int field2 = 2;
        
        B() {
            System.out.println("B 생성자 실행");
        }
        
        void method1() {
            System.out.println("B method1 실행");
        }
        
        static void method2() {
            System.out.println("B mehtod2 실행");
        }
    }

    void useB() {
        // B의 인스턴스 필드 및 메소드 사용
        B b = new B();

        System.out.println(b.field1);
        b.method1();

        // B의 정적 필드 및 메소드 사용
        System.out.println(B.field2);
        B.method2();
    }
}
