package strage;

public enum Hand {
    ROCK("바위", 0),
    SCISSOR("가위", 1),
    PAPER("보", 2);

    private String name;    // 손의 이름 : 가위, 바위, 보
    private int handvalue;  // 손의 값 : 0, 1, 2

    private Hand(String name, int handvalue) {
        this.name = name;
        this.handvalue = handvalue;
    }

    private static Hand[] hands = {
        ROCK, SCISSOR, PAPER
    };

    public static Hand getHand(int handvalue) {
        return hands[handvalue];
    }

    private int fight(Hand h) {
        if (this == h) {
            return 0;   // 무승부
        } else if ((this.handvalue + 1) % 3 == h.handvalue) {
            return 1;   // this가 이기는 경우
        } else {
            return -1;  // 상대가 이기는 경우
        }
    }

    // this가 상대방보다 강한지 여부
    public boolean isStrongerThan(Hand h) {
        return fight(h) == 1;
    }

    // this가 상대방보다 약한지 여부
    public boolean isWeakerThan(Hand h) {
        return fight(h) == -1;
    }

    // 손의 이름을 리턴함
    @Override
    public String toString() {
        return name;
    }
}
