package ch06.sec07.exam05;

public class CarExample {
    public static void main(String[] args) {

        // 어떤 생성자를 부르든 내부에서 세개짜리 생서자를 호출함.
        Car car1 = new Car("자가용");
        System.out.println(car1.company);
        System.out.println(car1.model);
        System.out.println();

        Car car2 = new Car("자가용", "빨강");
        System.out.println(car2.company);
        System.out.println(car2.model);
        System.out.println(car2.color);
        System.out.println();

        Car car3 = new Car("택시", "검정", 200);
        System.out.println(car3.company);
        System.out.println(car3.model);
        System.out.println(car3.color);
        System.out.println(car3.maxSpeed);
        System.out.println();
    }
}
