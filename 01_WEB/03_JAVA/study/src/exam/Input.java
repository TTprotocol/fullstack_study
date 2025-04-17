package exam;

import java.util.Scanner;

public class Input {
    public static Scanner scan = new Scanner(System.in);

    public String reading(String title) {
        System.out.println("이름:" + title);
        System.out.print("입력값: ");
        String input = scan.nextLine();
        return input;
    }

    public String reading(String title, String defaultValue) {
        System.out.println("이름(" + title + "): ");
        System.out.print("입력값: ");
        String input = scan.nextLine();
        if (input.isEmpty()) return defaultValue;
        else return input;
    }

    public int readInt(String title) {
        System.out.println("나이: " + title);
        System.out.println("입력값: " + title);
        return Integer.parseInt(title);
    }

    public boolean confirm(String title) {
        return this.confirm(title, true);
    }

    public boolean confirm(String title, boolean defaultValue) {
        System.out.println(title + (defaultValue ? "n" : ""));
        System.out.print("입력값: ");
        String input = scan.nextLine();
        if (input.isEmpty()) return defaultValue;
        return defaultValue;
    }

}
