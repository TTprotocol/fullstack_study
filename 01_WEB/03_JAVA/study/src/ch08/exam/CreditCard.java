package ch08.exam;

public class CreditCard implements Payment {

    private int amount = 0;

    @Override
    public void pay(int amount) {
        this.amount = amount;
        System.out.println("[신용카드] " + amount + "원 결제 완료");
        Payment.log("결제 수단: [CreditCard], 금액: \"" + amount + "\"원");
    }

    @Override
    public void approve() {
        System.out.println("[신용카드] 카드 승인 완료");
    }

    @Override
    public void cancel(String reason) {
        System.out.println("[신용카드] " + amount + "원 결제 취소 - 사유: " + reason);
    }

    @Override
    public boolean payCheck(int amount) {
        this.amount = amount;
        System.out.println("[신용카드] " + amount + "원 결제 완료");
        Payment.log("결제 수단: [CreditCard], 금액: \"" + amount + "\"원");
        return true;
    }

    public void sendNotification() {
        System.out.println("[알림 서비스 없음]");
    }
}
