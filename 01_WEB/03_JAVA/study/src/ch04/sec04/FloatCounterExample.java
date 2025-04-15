package ch04.sec04;

public class FloatCounterExample {
    public static void main(String[] args) {
        for (float x = 0.1f; x <= 1.0f; x += 0.1f) {
            // float는 for문에 사용하기에는 좋지 않다.
            System.out.println(x);
        }
    }
}
