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

//        MaleCelebrity[] maleCelebs = {
//                new MaleCelebrity("박서준"),
//                new MaleCelebrity("차은우"),
//                new MaleCelebrity("정해인")
//        };
//
//        FemaleCelebrity[] femaleCelebs = {
//                new FemaleCelebrity("아이유"),
//                new FemaleCelebrity("장원영")
//        };
//
//        System.out.println("=== 이상형 월드컵 ===");
//        System.out.println("1. 남자 연예인 월드컵");
//        System.out.println("2. 여자 연예인 월드컵");
//        System.out.print("경기를 선택하세요 : ");
//        Scanner genderSelect = new Scanner(System.in);
//
//        try {
//            if (!genderSelect.hasNextInt()) {
//                throw new InvalidGenderException(">> 숫자만 입력하세요! (1 또는 2)");
//            }
//
//            int gender = genderSelect.nextInt();
//
//            if (gender == 1) {
//                new MaleMatchGame(maleCelebs).printCandidates();
//            } else if (gender == 2) {
//                new FemaleMatchGame(femaleCelebs).printCandidates();
//            } else {
//                throw new InvalidGenderException(">> 잘못된 선택입니다! 1 또는 2만 입력하세요.");
//            }
//
//        } catch (InvalidGenderException e) {
////            System.out.println(e.getMessage()); // 메시지를 직접 출력
//        }

//        MaleCelebrity[] maleCelebs = {
//                new MaleCelebrity("박서준"),
//                new MaleCelebrity("차은우"),
//                new MaleCelebrity("정해인"),
//                new MaleCelebrity("이도현"),
//                new MaleCelebrity("송강"),
//                new MaleCelebrity("김선호"),
//                new MaleCelebrity("안효섭"),
//                new MaleCelebrity("도경수"),
//                new MaleCelebrity("임시완"),
//                new MaleCelebrity("이준호")
//        };
//
//        FemaleCelebrity[] femaleCelebs = {
//                new FemaleCelebrity("아이유"),
//                new FemaleCelebrity("장원영"),
//                new FemaleCelebrity("카리나"),
//                new FemaleCelebrity("윈터"),
//                new FemaleCelebrity("한소희"),
//                new FemaleCelebrity("김세정"),
//                new FemaleCelebrity("윤아"),
//                new FemaleCelebrity("설현"),
//                new FemaleCelebrity("제니"),
//                new FemaleCelebrity("지수"),
//        };
//
//        System.out.println("=== 이상형 월드컵 ===");
//        System.out.println("1. 남자 연예인 월드컵");
//        System.out.println("2. 여자 연예인 월드컵");
//        System.out.print("경기를 선택하세요 : ");
//        Scanner genderSelect = new Scanner(System.in);
//
//        try {
//            if (!genderSelect.hasNextInt()) {
//                throw new InvalidGenderException(">> 숫자만 입력하세요! (1 또는 2)");
//            }
//
//            int gender = genderSelect.nextInt();
//            System.out.println();
//
//            if (gender == 1) {
////                new MaleMatchGame(maleCelebs).printCandidates();
//
//                MaleMatchGame temp = new MaleMatchGame(maleCelebs);
//                System.out.println("[셔플 전 참가자 명단]");
//                temp.printCandidates();
//                System.out.println();
//                temp.shuffle();
//                System.out.println("[셔플 후 참가자 명단]");
//                temp.printCandidates();
//            } else if (gender == 2) {
////                new FemaleMatchGame(femaleCelebs).printCandidates();
//
//                FemaleMatchGame temp = new FemaleMatchGame(femaleCelebs);
//                System.out.println("[셔플 전 참가자 명단]");
//                temp.printCandidates();
//                System.out.println();
//                temp.shuffle();
//                System.out.println("[셔플 후 참가자 명단]");
//                temp.printCandidates();
//            } else {
//                throw new InvalidGenderException(">> 잘못된 선택입니다! 1 또는 2만 입력하세요.");
//            }
//
//        } catch (InvalidGenderException e) {
////            System.out.println(e.getMessage()); // 메시지를 직접 출력
//        }


        MaleCelebrity[] maleCelebs = {
                new MaleCelebrity("박서준"),
                new MaleCelebrity("차은우"),
                new MaleCelebrity("정해인"),
                new MaleCelebrity("이도현"),
                new MaleCelebrity("송강"),
                new MaleCelebrity("김선호"),
                new MaleCelebrity("안효섭"),
                new MaleCelebrity("도경수"),
                new MaleCelebrity("임시완"),
                new MaleCelebrity("이준호")
        };

        FemaleCelebrity[] femaleCelebs = {
                new FemaleCelebrity("아이유"),
                new FemaleCelebrity("장원영"),
                new FemaleCelebrity("카리나"),
                new FemaleCelebrity("윈터"),
                new FemaleCelebrity("한소희"),
                new FemaleCelebrity("김세정"),
                new FemaleCelebrity("윤아"),
                new FemaleCelebrity("설현"),
                new FemaleCelebrity("제니"),
                new FemaleCelebrity("지수"),
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
            System.out.println();

            if (gender == 1) {
                MaleMatchGame temp = new MaleMatchGame(maleCelebs);
                System.out.println("[셔플 된 참가자 명단]");
                temp.shuffle();
                temp.printCandidates();
                System.out.println();

                Celebrity winner = temp.playGame();
                System.out.println("\uD83C\uDFC6 최종 우승자 : " + winner);
            } else if (gender == 2) {
                FemaleMatchGame temp = new FemaleMatchGame(femaleCelebs);
                System.out.println("[셔플 된 참가자 명단]");
                temp.shuffle();
                temp.printCandidates();

                Celebrity winner = temp.playGame();
                System.out.println("\uD83C\uDFC6 최종 우승자 : " + winner);
            } else {
                throw new InvalidGenderException(">> 잘못된 선택입니다! 1 또는 2만 입력하세요.");
            }

        } catch (InvalidGenderException e) {
//            System.out.println(e.getMessage()); // 메시지를 직접 출력
        }

    }
}
