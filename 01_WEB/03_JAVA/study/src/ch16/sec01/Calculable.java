package ch16.sec01;

// FunctionalInterface : 추상 메서드가 하나인지 확인해주는 역할
@FunctionalInterface
public interface Calculable {
    //추상 메소드
    void calculate(int x, int y);
}
