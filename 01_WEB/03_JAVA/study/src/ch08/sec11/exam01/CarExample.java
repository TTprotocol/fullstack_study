package ch08.sec11.exam01;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.run();

        // 리스코프 치환 원칙 : 메인 로직의 영향 X
        // 부모가 같으면 어떤 자식이 들어가든 정상 동작해야 한다.
        myCar.tire1 = new KumhoTire();
        myCar.tire2 = new KumhoTire();
        myCar.run();
    }
}
