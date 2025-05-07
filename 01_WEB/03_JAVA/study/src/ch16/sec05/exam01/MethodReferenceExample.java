package ch16.sec05.exam01;

public class MethodReferenceExample {
    public static void main(String[] args) {
        Person person = new Person();
        // 정적 메서드일 경우
        person.action(Computer::staticMethod);

        Computer com = new Computer();
        // 인스턴스 메서드일 경우
        person.action(com::instanceMethod);
    }
}
