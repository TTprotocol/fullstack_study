package ch09.sec03.exam02;

public class AExample {
    public static void main(String[] args) {

        A.B b = new A.B();
        System.out.println(b.field1); b.method1();

        A.B.method2();
    }
}
