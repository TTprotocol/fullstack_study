package ch16.sec04;

@FunctionalInterface
public interface Calculable {
    // double 값 2개를 받아서 1개를 리턴.
    double calc(double x, double y);
}
