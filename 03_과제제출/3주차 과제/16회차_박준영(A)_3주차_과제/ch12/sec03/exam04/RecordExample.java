package ch12.sec03.exam04;

public class RecordExample {
    public static void main(String[] args) {
        // record 객체 생성
        Member m = new Member("winter", "눈송이", 25);
        System.out.println(m.id()); // id() : getter 역할을 하는 메소드
        System.out.println(m.name());
        System.out.println(m.age());
        System.out.println(m.toString());
        System.out.println();
        
        // 값이 동일한 두 객체 생성
        Member m1 = new Member("winter", "눈송이", 25);
        Member m2 = new Member("winter", "눈송이", 25);

        // m1과 m2의 해시코드가 동일하기 때문에 equals가 true로 나온다.
        System.out.println("m1.hashCode(): " + m1.hashCode());
        System.out.println("m2.hashCode(): " + m2.hashCode());
        System.out.println("m1.equals(m2): " + m1.equals(m2));
    }
}