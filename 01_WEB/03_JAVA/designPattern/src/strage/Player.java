package strage;

public class Player {
    private String name;
    private Strategy strategy;  // 전략
    private int wincount;   // 승리 횟수
    private int losecount;  // 패배 횟수
    private int evencount;  // 비긴 횟수
    private int gamecount;  // 총 게임 횟수

    // 생성자.
    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    // 가진 전략에 따른 다음에 낼 수
    // 다음에 낼 손을 결정하는 것은 전략 객체에 위임
    public Hand nextHand() {
        return strategy.nextHand();
    }

    // 전략 객체에 이겼다고 학습시킴
    public void win() {
        strategy.study(true);
        wincount++;
        gamecount++;
    }

    // 전략 객체에 졌다고 학습시킴
    public void lose() {
        strategy.study(false);
        losecount++;
        gamecount++;
    }

    // 비김
    public void even() {
        gamecount++;
        evencount++;
    }

    @Override
    public String toString() {
        return "[" + name + ":" + gamecount + " games, " + wincount + " win, " + losecount + " lose " + evencount + " even]";
    }
}
