package ch11.sec02.axam01;

public class ExceptionHandlingExample1 {
    public static void printLength(String data) {
        try {
            int result = data.length();
            System.out.println("문자 수: " + result);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage()); // 예외 원인 메시지 출력
            System.out.println(e.toString());   // 예외 타입 + 메시지 출력
            e.printStackTrace(); // 예외 발생 위치까지 출력
        } finally {
            // 예외 발생 여부에 상관없이 무조건 샐행
            System.out.println("[마무리 실행]\n");
        }
    } 

    // NullPointerException 예외 발생
    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n"); printLength("ThisIsJava");
        printLength(null); System.out.println("[프로그램 종료]");
    }
}
