package ch13.sec02.exam02;

public class CarAgency implements Rentable<Car>{
    @Override
    public Car rent() { // 리턴타입이 P와 동일하게 결정
        return new Car();
    }
}
