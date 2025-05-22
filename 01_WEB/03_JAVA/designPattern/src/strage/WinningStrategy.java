package strage;

import java.util.Random;

public class WinningStrategy implements Strategy {
    private Random random;
    private boolean won = false;    // 직전 게임에서 이겼는지 여부
    private Hand prevHand;  // 이전에 냈던 손의 모양

    public WinningStrategy(int seed) {
        random = new Random(seed);  // 고정된 시드를 가진 난수 생성기
    }

    @Override
    public Hand nextHand() {
        if (!won) { // 직전 게임에서 졌다면
            prevHand = Hand.getHand(random.nextInt(3)); // 랜덤으로 새 손을 선택
        }
        return prevHand;    // 이겼으면 기존의 손을 그대로 사용
    }

    @Override
    public void study(boolean win) {
        // 직전 게임의 승패 결과를 저장
        won = win;
    }
}
