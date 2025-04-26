package ch06.sec07.exam03;

public class Korean {
    // 필드 선언
    String nation = "대한민국";
    String name;
    String ssn;

    // alt + insert => 생성자 => 변수 선택
    public Korean(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    // alt + insert => 생성자 => 선택 안함 = 기본 생성자
    public Korean() {
    }
}
