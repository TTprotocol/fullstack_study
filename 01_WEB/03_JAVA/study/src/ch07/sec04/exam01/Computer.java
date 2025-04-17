package ch07.sec04.exam01;

public class Computer extends Calculator {
    //메소드 오버라이딩
    // 컴파일 시 오버라이딩을 체크하기 위한 권장사항
    @Override // 컴파일 시 정확히 오버라이딩이 되었는지 체크 해줌
    public double areaCircle(double r) {
        System.out.println("Computer 객체의 areaCircle() 실행");
        return Math.PI * r * r;
    }
}

