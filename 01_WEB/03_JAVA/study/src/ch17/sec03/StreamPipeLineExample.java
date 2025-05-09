package ch17.sec03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipeLineExample {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
            new Student("홍길동", 10),
            new Student("신용권", 20), new Student("유미선", 30));

        // 방법1 : Stream 변수 분리
        Stream<Student> studentStream = list.stream();
        // 중간 처리(학생 객체를 점수로 매핑) = 점수만 추출한다.
        IntStream scoreStream = studentStream.mapToInt(student -> student.getScore());
        // 최종 처리(평균 점수) => .average()는 OptionalDouble 이므로, .getAsDouble()로 타입을 변환해준다.
        double avg1 = scoreStream.average().getAsDouble();
        System.out.println("평균 점수: " + avg1);

        // 방법2 : 파이프라인 메서드 체이닝을 이용하여 위 계산을 한 번에 수행한다.
        double avg2 = list.stream()
            .mapToInt(student -> student.getScore()).average()
            .getAsDouble();
        System.out.println("평균 점수: " + avg2);
    }
}
