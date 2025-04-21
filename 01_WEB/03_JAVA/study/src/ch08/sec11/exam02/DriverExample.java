package ch08.sec11.exam02;

public class DriverExample {
    public static void main(String[] args) {
        Driver driver = new Driver();

        Bus bus = new Bus();
        Taxi taxi = new Taxi();

        // 매개변수의 다형성
        // 매개값으로 구현 객체 대입.
        driver.drive(bus);  // 자동 타입 변환 : Bus -> Vehicle
        driver.drive(taxi); // 자동 타입 변환 : Taxi -> Vehicle
    }
}
