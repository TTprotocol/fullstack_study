package ch16.sec01;

public class LambaExample {
    public static void main(String[] args) {
        action((x, y) -> {
            int result = x + y;
            System.out.println("result: " + result);
        });

        action((x, y) -> {
            int result = x - y;
            System.out.println("result: " + result);
        });
    }

    
    public static void action (Calculable calculable) {
        int x = 10;
        int y = 4;

        // 전달받은 람다식에 따라 다르게 실행됨.
        calculable.calculate(x, y);
    }
}