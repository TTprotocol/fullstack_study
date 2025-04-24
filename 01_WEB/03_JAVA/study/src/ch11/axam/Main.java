package ch11.axam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidNameException {
//        System.out.print("참가자 이름을 입력하세요 : ");
//        Scanner sc = new Scanner(System.in);
//
//        String name = sc.nextLine();
//
//        try {
//            NameValidator.validate(name);
//            System.out.println("(다음 단계로 진행합니다!)");
//        } catch (InvalidNameException e) {
//            System.out.println("\uD83D\uDE21 탈락! 잘못된 이름입니다: " + e.getMessage());
//        }

//        MaleCelebrity[] maleCelebs = {
//            new MaleCelebrity("박서준"),
//            new MaleCelebrity("차은우"),
//            new MaleCelebrity("정해인")
//        };
//
//        FemaleCelebrity[] femaleCelebs = {
//            new FemaleCelebrity("아이유"),
//            new FemaleCelebrity("장원영")
//        };
//
//        MaleMatchGame maleGame = new MaleMatchGame(maleCelebs);
//        maleGame.printCandidates();
//
//        FemaleMatchGame femaleGame = new FemaleMatchGame(femaleCelebs);
//        femaleGame.printCandidates();

        MaleCelebrity[] maleCelebs = {
                new MaleCelebrity("박서준"),
                new MaleCelebrity("차은우"),
                new MaleCelebrity("정해인")
        };

        FemaleCelebrity[] femaleCelebs = {
                new FemaleCelebrity("아이유"),
                new FemaleCelebrity("장원영")
        };

        System.out.println("=== 이상형 월드컵 ===");
        System.out.println("1. 남자 연예인 월드컵");
        System.out.println("2. 여자 연예인 월드컵");
        System.out.print("경기를 선택하세요 : ");
        Scanner genderSelect = new Scanner(System.in);

        try {
            if (!genderSelect.hasNextInt()) {
                throw new InvalidGenderException(">> 숫자만 입력하세요! (1 또는 2)");
            }

            int gender = genderSelect.nextInt();

            if (gender == 1) {
                new MaleMatchGame(maleCelebs).printCandidates();
            } else if (gender == 2) {
                new FemaleMatchGame(femaleCelebs).printCandidates();
            } else {
                throw new InvalidGenderException(">> 잘못된 선택입니다! 1 또는 2만 입력하세요.");
            }

        } catch (InvalidGenderException e) {
//            System.out.println(e.getMessage()); // 메시지를 직접 출력
        }

    }
}
