package ch17.sec06.exam02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MapExample {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};

        IntStream intStream = Arrays.stream(intArray);
        
        // int -> double 스트림 변환
        intStream
            .asDoubleStream().forEach(d -> System.out.println(d));
        System.out.println();
        
        intStream = Arrays.stream(intArray);
        
        // int -> Integer 객체 스트림 변환 
        intStream
            .boxed()
            // 래퍼 객체에서 .intValue()로 다시 int 추출 가능
            .forEach(obj -> System.out.println(obj.intValue()));
    }
}
