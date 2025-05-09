package ch17.sec12.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {
    public static void main(String[] args) {
        List<Student> totalList = new ArrayList<>();
        totalList.add(new Student("홍길동", "남", 92));
        totalList.add(new Student("김수영", "여", 87));
        totalList.add(new Student("감자바", "남", 95));
        totalList.add(new Student("오해영", "여", 93));

        //남학생만 묶어 List 생성
        /*
        List<Student> maleList = totalList.stream().filter(s->s.getSex().equals("남")).collect(Collectors.toList());
        */

        // 스트림을 사용하는 경우
        List<Student> maleList = totalList.stream()
            .filter(s -> s.getSex().equals("남"))
            .toList();

        maleList.stream()
            .forEach(s -> System.out.println(s.getName()));

        // 스트림으로 변환하지 않아도 forEach() 는 쓸 수 있지만, 대신 중간처리를 할 수 없다.
        maleList    // .stream()
            .forEach(s -> System.out.println(s.getName()));

        // 메서드 참조로 변경한 코드
        maleList.forEach(System.out::println);

        System.out.println();

        maleList.stream().map(Student::getName).forEach(System.out::println);

        //학생 이름을 키, 학생의 점수를 값으로 갖는 Map 생성
        Map<String, Integer> map = totalList.stream()
            .collect(
                Collectors.toMap(
                    // s -> s.getName(), //Student 객체에서 키가 될 부분 리턴
                    // s -> s.getScore() //Student 객체에서 값이 될 부분 리턴
                    // 람다식(s -> s.getName())을 메서드 참조(Student::getName)로 변경
                    Student::getName,
                    Student::getScore
                )
            );
        System.out.println(map);

        // ----------------------------------------------------------------------------

        // 학생 리스트에서 성적순으로 정렬하여 2명만 뽑아내는 코드.
        // 이러한 코드를 '선언적 프로그래밍'이라고 한다.
        // 즉, A 해줘, B 해줘, C 해줘 등 여러번 요청하는 방식이다.
        List<Student> topList = totalList.stream()
            .sorted(
                // 내림차순으로 정렬
                (a, b) -> Integer.compare(b.getScore(), a.getScore())
            )
            .limit(2)   // 상위 2명
            .toList();
        topList.forEach(System.out::println);

        // ----------------------------------------------------------------------------


    }
}
