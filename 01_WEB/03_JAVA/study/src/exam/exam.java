package exam;

import java.util.Scanner;

public class exam {
    public static void main(String[] args) {
//        for (int i = 0; i <= 10; i++) {
//            for (int j = 0; j <= 10; j++) {
//                if (((4 * i) + (5 * j)) == 60) System.out.println("x : " + i + ", y : " + j);
//            }
//        }

//        int[][] array = {
//                {95, 86},
//                {92, 92, 96},
//                {78, 83, 93, 87, 88},
//        };
//
//        System.out.println(array.length);
//        System.out.println(array[2].length);

//        int[] array = {1, 5, 3, 8, 2};
//        int max = 0;
//
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] > max) {
//                max = array[i];
//            }
//        }
//
//        System.out.println(max);

//        int sum = 0;
//        int count = 0;
//        double avg = 0;
//        int[][] array = {
//                {95, 86},
//                {83, 92, 96},
//                {78, 83, 93, 87, 88},
//        };
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                sum += array[i][j];
//            }
//            count += array[i].length;
//        }
//        avg = (double) sum / count;
//
//        System.out.println("합계 : " + sum);
//        System.out.println("평균 : " + avg);
//
//        boolean flag = true;
//        int account = 0;
//
//        do {
//            System.out.println("-----------------------------");
//            System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
//            System.out.println("-----------------------------");
//            System.out.print("선택: ");
//
//            Scanner select = new Scanner(System.in);
//            int selectItem = select.nextInt();
//            if (selectItem == 1) {
//                System.out.print("예금액: ");
//                Scanner amount = new Scanner(System.in);
//
//                int amountItem = amount.nextInt();
//                account += amountItem;
//            } else if (selectItem == 2) {
//                System.out.print("출금액: ");
//                Scanner amount = new Scanner(System.in);
//
//                int amountItem = amount.nextInt();
//                account -= amountItem;
//            } else if (selectItem == 3) {
//                System.out.println("잔고> " + account);
//            } else {
//                flag = false;
//            }
//        } while (flag);

        boolean flag = true;
        int[] student = new int[0];
        int count = 0;

        do {
            System.out.println("-----------------------------");
            System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
            System.out.println("-----------------------------");
            System.out.print("선택: ");

            Scanner select = new Scanner(System.in);
            int selectItem = select.nextInt();

            if (selectItem == 1) {
                System.out.print("학생수: ");
                Scanner amount = new Scanner(System.in);

                int amountItem = amount.nextInt();
                student = new int[amountItem];
            } else if (selectItem == 2) {
                for (int i = 0; i < student.length; i++) {
                    System.out.print("scores[" + i + "]: ");
                    Scanner amount = new Scanner(System.in);

                    int amountItem = amount.nextInt();
                    student[i] = amountItem;
                }
            } else if (selectItem == 3) {
                for (int i = 0; i < student.length; i++) {
                    System.out.println("scores[" + i + "]: " + student[i]);
                }
            } else if (selectItem == 4) {
                int max = 0;
                int sum = 0;
                for (int j : student) {
                    if (j > max) max = j;
                    sum += j;
                }
                System.out.println("최고 점수: " + max);
                System.out.println("평균 점수: " + (double) sum / student.length);
            } else {
                flag = false;
            }
        } while (flag);
        System.out.println("프로그램 종료");
    }
}
