package ch12.sec03.exam05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data   // getter, setter, toString, equals, hashCode
@NoArgsConstructor  // 기본 생성자
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자
public class Member {
    private String id;
    @NonNull
    private String name;
    private int age;
}
