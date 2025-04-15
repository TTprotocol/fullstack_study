package ch05;

public class ArgTest {
    public static void main(String[] args) {
        // main 메서드의 매개변수인 String[] args는 무엇일까?
        System.out.println(args.length);    // 결과 : 0. 실행 됨 => null이 아님.

        // 구성 편집에서 전달할 인수에 abc efg fff로 준 경우
        System.out.println(args[0]);    // 결과 : abc

    }
}
