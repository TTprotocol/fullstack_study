package ch11.axam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("참가자 이름을 입력하세요 : ");
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();

        try {
            NameValidator.validate(name);
            System.out.println("(다음 단계로 진행합니다!)");
        } catch (InvalidNameException e) {
            System.out.println("\uD83D\uDE21 탈락! 잘못된 이름입니다: " + e.getMessage());
        }
    }
}
