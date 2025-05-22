package ch15.exam.doll;

import ch15.exam.doll.queue.DollQueueManager;
import ch15.exam.doll.queue.DollStackManager;
import ch15.exam.doll.util.RandomCustomerProvider;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RandomCustomerProvider randomCustomer = new RandomCustomerProvider();
        DollQueueManager doll = new DollQueueManager();
        DollStackManager dollStack = new DollStackManager();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 유라의 인형뽑기 가게 ===");
        System.out.println("[1] 고객 등록");
        System.out.println("[2] 뽑기 진행 (인형 보관)");
        System.out.println("[3] 현재 대기열 보기");
        System.out.println("[4] 현재 보관함 보기");
        System.out.println("[0] 종료");

        while (true) {
            System.out.print("선택 >> ");
            int select = sc.nextInt();

            if (select == 1) {
                String custom = RandomCustomerProvider.getRandomCustomer();
                System.out.println(custom + " 님이 대기열에 등록되었습니다.");
                doll.registerCustomer(custom);
            } else if (select == 2) {
                String custom = doll.processNextCustomer();
                if (custom != null) {
                    dollStack.storeRandomDoll();
                } else {
                    System.out.println("등록된 고객이 없어 뽑기 진행이 불가합니다.");
                }
            } else if (select == 3) {
                doll.showWaitingList();
            } else if (select == 4) {
                dollStack.showStack();
            } else if (select == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
