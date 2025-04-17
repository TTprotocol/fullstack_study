package exam;

public class InputTest {
    public static void main(String[] args) {
        Input input = new Input();

        String input1 = input.reading("이세돌");
        String input2 = input.reading("홍길동", "");
        int input3 = input.readInt("10");
        boolean input4 = input.confirm("종료할까요? (Y/n): ");
        boolean input5 = input.confirm("종료할까요? (Y/n): ", false);
    }
}
