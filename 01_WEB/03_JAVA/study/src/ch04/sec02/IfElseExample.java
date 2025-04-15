package ch04.sec02;

public class IfElseExample {
    public static void main(String[] args) {
        int score = 85;

        if(score >= 90) {
            System.out.println("점수가 90보다 큽니다."); System.out.println("등급은 A입니다.");
        } else {
            // if 조건문의 나머지 케이스가 실행된다.
            System.out.println("점수가 90보다 작습니다."); System.out.println("등급은 B입니다.");
        }
    }
}
