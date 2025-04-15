package ch04.sec07;

public class BreakExample {
    public static void main(String[] args) {
        int count = 0;
        while (true) {
            int num = (int) (Math.random() * 6) + 1;

            System.out.println(num);
            count++;

            if (num == 6) {
                // 값이 6인 경우 반복문 종료
                break;
            }
        }
        System.out.println("프로그램 종료. count : " + count);
    }
}
