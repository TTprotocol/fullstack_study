package ch07.sec07.exam02;

public class ChildExample {
    public static void main(String[] args) {
        // 자식 객체 생성
        Child child = new Child();

        // 자동 타입 변환
        Parent parent = child;  // 업캐스팅

        parent.method1();
        parent.method2();   // 오버라이딩 된 메소드는 자식 메소드로 접근
        // parent.method3();    // 자식에만 있는 메소드는 접근 불가
    }
}
