package ch11.sec05;

public class ThrowsExample1 {
    public static void main(String[] args) {
        try {
            findClass();
        } catch (ClassNotFoundException e) {    // findClass() 에서 발생한 예외
            System.out.println("예외 처리: " + e.toString());
        }
    }

    // 예외를 직접 처리하지 않고, 호출한 곳으로 떠넘김 (throws 사용)
    public static void findClass() throws ClassNotFoundException {
        Class.forName("java.lang.String2");
    }
}
