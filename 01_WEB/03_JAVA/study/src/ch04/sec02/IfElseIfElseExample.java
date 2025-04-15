package ch04.sec02;

public class IfElseIfElseExample {
    public static void main(String[] args) {
        int score = 75;

        if (score >= 90) {
            System.out.println("점수가 90~100입니다.");
            System.out.println("등급은 A입니다.");
        } else if (score >= 80) {
            // if에서 필터링 된 데이터만 들어오기 때문에 별도의 and 구문을 쓸 필요는 없다.
            System.out.println("점수가 80~89입니다.");
            System.out.println("등급은 B입니다.");

        } else if (score >= 70) {
            System.out.println("점수가 70~79입니다.");
            System.out.println("등급은 C입니다.");

        } else {
            System.out.println("점수가 70 미만입니다.");
            System.out.println("등급은 D입니다.");

        }
    }
}
