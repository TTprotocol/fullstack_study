package ch08.exam;

public interface Payment {
    static void log(String message) {
        System.out.println("[LOG] " + message);
    }

    void pay(int amount);

    void approve();

    void cancel(String reason);

    boolean payCheck(int amount);

    default boolean beforePay() {
        System.out.println("[공통] 결제를 준비합니다...");
        return true;
    }
}
