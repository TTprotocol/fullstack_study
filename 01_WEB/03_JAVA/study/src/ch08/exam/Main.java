package ch08.exam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Payment payment = new KakaoPay();
//
//        payment.pay(3000);
//        payment.pay(7000);
//        payment.approve();
//        payment.cancel("오입력");

//        Payment[] payments = {
//                new CreditCard(),
//                new KakaoPay(),
//                new KakaoPay(),
//                new CreditCard()
//        };
//
//        for (int i = 0; i < payments.length; i++) {
//            System.out.println("[" + (i + 1) + "번 결제수단] 결제 금액을 입력하세요 :");
//            System.out.print(">> ");
//            Scanner sc = new Scanner(System.in);
//
//            boolean check = payments[i].payCheck(sc.nextInt());
//
//            if (check) {
//                payments[i].approve();
//                payments[i].cancel("테스트 취소");
//            } else {
//                System.out.println("[결제 실패: 승인/취소 건너뜀]");
//            }
//            System.out.println();
//        }

//        System.out.println("=== 결제 수단 선택 ===");
//        System.out.println("[1] 신용카드");
//        System.out.println("[2] 카카오페이");
//        System.out.print("결제 수단을 선택하세요: ");
//        Scanner sc = new Scanner(System.in);
//
//        if (sc.nextInt() == 1) {
//            Payment payment = new CreditCard();
//
//            System.out.print("결제 금액을 입력하세요: ");
//            Scanner amount = new Scanner(System.in);
//
//            payment.payCheck(amount.nextInt());
//            payment.approve();
//            payment.cancel("테스트 취소");
//
//            if (payment instanceof CreditCard creditCard) {
//                creditCard.sendNotification();
//            }
//        } else {
//
//            Payment payment = new KakaoPay();
//
//            System.out.print("결제 금액을 입력하세요: ");
//            Scanner amount = new Scanner(System.in);
//
//            payment.payCheck(amount.nextInt());
//            payment.approve();
//            payment.cancel("테스트 취소");
//
//            if (payment instanceof KakaoPay kakaoPay) {
//                kakaoPay.sendNotification();
//            }
//        }

//        System.out.println("=== 유니페이 결제 시스템 ===");
//        System.out.println("[1] 신용카드");
//        System.out.println("[2] 카카오페이");
//        System.out.print("결제 수단을 선택하세요: ");
//        Scanner sc = new Scanner(System.in);
//        int selelct = sc.nextInt();
//
//        Payment payment;
//
//        if (selelct == 1) {
//            payment = new CreditCard();
//        } else {
//            KakaoPay kakaoPay = new KakaoPay();
//
//            System.out.print("[카카오페이 사용자 인증을 진행하시겠습니까? (y/n)] ");
//            Scanner auth = new Scanner(System.in);
//
//            if (auth.nextLine().equals("y") || auth.nextLine().equals("Y")) {
//                kakaoPay.authenticate();
//            }
//            payment = kakaoPay;
//        }
//
//        boolean before = payment.beforePay();
//
//        if (before) {
//            System.out.print("결제 금액을 입력하세요: ");
//            Scanner amount = new Scanner(System.in);
//
//            payment.payCheck(amount.nextInt());
//            payment.approve();
//            payment.cancel("테스트 취소");
//        } else {
//            System.out.println("[결제 실패: 준비 단계에서 중단]");
//        }
//
//        if (selelct == 1) {
//            CreditCard credit = (CreditCard) payment;
//
//            credit.sendNotification();
//        } else {
//            KakaoPay kakao = (KakaoPay) payment;
//
//            kakao.sendNotification();
//        }

        Payment payment = null;
        KakaoPay kakaoPay = new KakaoPay();
        CreditCard creditCard = new CreditCard();
        PaymentManager paymentManager = new PaymentManager();

        while (true) {
            System.out.println("=== 유니페이 결제 시스템 ===");
            System.out.println("[1] 신용카드");
            System.out.println("[2] 카카오페이");
            System.out.print("결제 수단을 선택하세요: ");

            Scanner sc = new Scanner(System.in);
            int select = sc.nextInt();

            if (select == 1) {
                payment = creditCard;
            } else if (select == 2) {
                System.out.print("[카카오페이 사용자 인증을 진행하시겠습니까? (y/n)] ");
                Scanner auth = new Scanner(System.in);
                if (auth.nextLine().equals("y")) {
                    kakaoPay.authenticate();
                } else {
                    System.out.println(">>" + auth.nextLine());
                }
                payment = kakaoPay;
            } else if (select == 0) {
                paymentManager.printSummary();
                break;
            }

            System.out.print("결제 금액을 입력하세요: ");
            Scanner amount = new Scanner(System.in);

            paymentManager.process(payment, amount.nextInt());
            System.out.println();
        }
    }
}
