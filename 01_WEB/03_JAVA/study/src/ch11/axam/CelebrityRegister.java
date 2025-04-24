package ch11.axam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CelebrityRegister {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MaleCelebrity> maleList = new ArrayList<>();
        List<FemaleCelebrity> femaleList = new ArrayList<>();

        System.out.print("남자 연예인 몇 명 등록할까요? ");
        int maleCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < maleCount; i++) {
            System.out.print("이름 입력: ");
            String name = scanner.nextLine();

            try {
                MaleCelebrity male = new MaleCelebrity(name);
                if (maleList.contains(male)) {
                    System.out.println(">> 중복된 이름입니다. 등록하지 않습니다.");
                    i--;
                } else {
                    maleList.add(male);
                }
            } catch (InvalidNameException e) {
                System.err.println(">> " + e.getMessage());
            }
        }


        System.out.print("여자 연예인 몇 명 등록할까요? ");
        int femaleCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < femaleCount; i++) {
            System.out.print("이름 입력: ");
            String name = scanner.nextLine();

            try {
                FemaleCelebrity female = new FemaleCelebrity(name);
                if (femaleList.contains(female)) {
                    System.out.println(">> 중복된 이름입니다. 등록하지 않습니다.");
                    i--;
                } else {
                    femaleList.add(female);
                }
            } catch (InvalidNameException e) {
                System.err.println(">> " + e.getMessage());
            }
        }

        System.out.println("\n[남자 연예인 리스트]");
        for (MaleCelebrity male : maleList) {
            System.out.println(male);
        }

        System.out.println("\n[여자 연예인 리스트]");
        for (FemaleCelebrity female : femaleList) {
            System.out.println(female);
        }
    }
}
