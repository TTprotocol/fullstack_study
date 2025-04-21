package ch08.exam;

public class PaymentManager {
    public int total = 0;
    public int totalAmount = 0;
    public int creditCardCount = 0;
    public int kakaoPayCount = 0;

    public void process(Payment payment, int amount) {
        boolean before = payment.beforePay();
        if (before) {
            boolean pay = payment.payCheck(amount);
            if (pay) {
                payment.approve();
                payment.cancel("테스트 취소");

                if (payment instanceof KakaoPay kakaoPay) {
                    kakaoPayCount++;
                    kakaoPay.sendNotification();
                } else {
                    creditCardCount++;
                    System.out.println("[알림 서비스 없음]");
                }
                total++;
                totalAmount += amount;
            } else {
                System.out.println();
            }
        } else {
            System.out.println();
        }
    }

    public void printSummary() {
        System.out.println("✅ 결제 통계 요약");
        System.out.println("총 결제 횟수: " + total + "회");
        System.out.println("총 결제 금액: " + totalAmount + "원");
        System.out.println("[CreditCard] : " + creditCardCount + "건");
        System.out.println("[KakaoPay] : " + kakaoPayCount + "건");
    }
}
