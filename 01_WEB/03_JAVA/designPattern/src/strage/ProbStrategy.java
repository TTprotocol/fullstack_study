package strage;

import java.util.Random;

public class ProbStrategy implements Strategy {
    private Random random;
    private int prevhandValue = 0;  // 이전에 냈던 손의 인덱스 (0 : 바위, 1 : 가위, 2 : 보)
    private int currentHandValue = 0;   // 이번에 낼 손의 인덱스
    private int[][] history = {
        {1, 1, 1},  // 바위를 낸 후 상대방이 바위/가위/보 를 낼 확률(가중치)
        {1, 1, 1},  // 가위를 낸 후 상대방이 바위/가위/보 를 낼 확률(가중치)
        {1, 1, 1},  // 보를 낸 후 상대방이 바위/가위/보 를 낼 확률(가중치)
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue));
        int handvalue = 0;

        // 누적 확률 분포 기반으로 선택
        if (bet < history[currentHandValue][0]) {
            // bet이 0~4 사이 -> 바위
            handvalue = 0;
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {
            // bet이 5~7 사이 -> 가위
            handvalue = 1;
        } else {
            // 나머지 8~9 사이 -> 보
            handvalue = 2;
        }

        // 이전 손과 현재 손 기록 저장
        prevhandValue = currentHandValue;
        currentHandValue = handvalue;
        return Hand.getHand(handvalue); // 선택된 손 객체 반환
    }

    // 현재 손에서 가능한 다음 손들의 가중치 총합 계산
    private int getSum(int handvalue) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            // history의 handvalue행의 모든 값을 더해준다.
            sum += history[handvalue][i];
        }
        return sum;
    }

    @Override
    public void study(boolean win) {
        if (win) {
            // 이겼다면, history에 해당 손 조합에 가중치 증가
            history[prevhandValue][currentHandValue]++;
        } else {
            // 졌다면, 해당 손 조합을 제외한 조합의 가중치 증가
            history[prevhandValue][(currentHandValue + 1) % 3]++;
            history[prevhandValue][(currentHandValue + 2) % 3]++;
        }
    }
}
