package ch17.sec04.exam03;

import java.util.stream.IntStream;

public class StreamExample {
    public static int sum;  // 합계 저장용 정적 필드

    public static void main(String[] args) {
        // 1부터 100까지의 정수 스트림 생성 (끝 포함)
        IntStream stream = IntStream.rangeClosed(1, 100);
        stream.forEach(a -> sum += a);  // 각 요소를 sum에 누적
        System.out.println("총합: " + sum);
    }
}
