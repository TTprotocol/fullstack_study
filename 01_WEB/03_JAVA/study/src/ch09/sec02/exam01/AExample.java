package ch09.sec02.exam01;

public class AExample {
    public static void main(String[] args) {
        A a = new A();

        // 객체 생성 후 B 객체 생성 가능
        A.B b = a.new B();
    }
}
