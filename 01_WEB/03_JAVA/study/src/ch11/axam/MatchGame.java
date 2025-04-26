package ch11.axam;

import java.util.*;

public abstract class MatchGame implements VsSelectable {
    protected Celebrity[] candidates;

    public abstract void initializeCandidates();

    public Celebrity playGame() {
        Celebrity[] nextRound = candidates;
        int round = 1;

        while (nextRound.length > 1) {
            List<Celebrity> temp = new ArrayList<>();
            int count = 0;

            System.out.println("=== " + round + "라운드 ===");

            while (count < nextRound.length) {
                if (count == nextRound.length - 1) {
                    // 홀수: 마지막 1명 자동 진출
                    temp.add(nextRound[count]);
                    System.out.println(nextRound[count] + "은(는) 자동으로 다음 라운드 진출!");
                    break;
                }

                // 2명 대결 (랜덤 승자 결정)
                Celebrity first = nextRound[count];
                Celebrity second = nextRound[count + 1];
                Celebrity winner = selectWinner(first, second);
                System.out.println("[" + winner + " 승리!]");
                temp.add(winner);

                count += 2;
            }
            nextRound = temp.toArray(new Celebrity[0]);
            round++;
            System.out.println();
        }

        return nextRound[0];
    }

    public void printCandidates() {
        for (Celebrity c : candidates) {
            System.out.println(c);
        }
    }

    public void shuffle() {
        /*
         * 배열의 마지막 자리부터 거꾸로 올라가면서,
         * 현재 위치와 그 앞의 아무 자리(0부터 현재 위치까지 중 하나)를 랜덤하게 골라서 서로 바꾸기
         * 이 과정을 배열 전체가 한 번씩 바뀔 때까지 반복
         * 같은 자리와 바꾸면 그냥 그대로 두는 거고,
         * 두 자리의 순서가 바뀌는 건 언제나 랜덤이야!
         * */

        Random rand = new Random();
        for (int i = 0; i < candidates.length; i++) {
            int j = rand.nextInt(i + 1);  // 0부터 i까지 중에서 선택

            Celebrity temp = candidates[i];
            candidates[i] = candidates[j];
            candidates[j] = temp;
        }
    }

    @Override
    public Celebrity selectWinner(Celebrity c1, Celebrity c2) {

        Celebrity winner;

        while (true) {
            System.out.println("누가 더 이상형인가요?");
            System.out.println("1. " + c1);
            System.out.println("2. " + c2);
            System.out.print("선택 : ");
            Scanner sc = new Scanner(System.in);

            if (!sc.hasNextInt()) {
                System.out.println("잘못된 입력입니다! 1 또는 2만 입력하세요.");
                continue;
            }

            int select = sc.nextInt();

            if (select == 1) {
                winner = c1;
                break;
            } else if (select == 2) {
                winner = c2;
                break;
            } else {
                System.out.println("잘못된 입력입니다! 1 또는 2만 입력하세요.");
            }
        }

        return winner;
    }
}
