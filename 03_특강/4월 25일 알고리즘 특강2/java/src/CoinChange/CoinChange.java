package CoinChange;

import java.util.LinkedList;
import java.util.Queue;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int answer = coinChange(coins, amount);
        System.out.println(answer);
    }

    public static int coinChange(int[] coins, int amount) {

        if (amount == 0) return 0;  // amount가 0이면 0개의 동전으로 해당 금액을 맞출 수 있음

        boolean[] visited = new boolean[amount + 1];    // 현재 금액에 방문했는지 여부를 체크
        Queue<int[]> queue = new LinkedList<>();    // 현재 금액과 현재 금액을 만들기 위한 동전의 개수를 저장하는 큐
        queue.offer(new int[]{0, 0});   // 초기 금액 0, 동전 개수 0

        // 큐가 빌때까지 진행
        while (!queue.isEmpty()) {
            int[] current = queue.remove(); // queue 가장 앞에 있는 값 = 현재 금액
            for (int coin : coins) {    // 현재 금액에 코인 각각의 금액을 더한다.
                int nextCoin = coin + current[0];

                if (nextCoin == amount) return current[1] + 1;  // 더해진 값이 제시된 금액이면 => 현재 동전 개수 + 1
                if (nextCoin < amount && !visited[nextCoin]) {  // 더해진 값이 아직 제시된 금액보다 작고, 해당 금액을 아직 방문하지 않음 => 큐에 해당 금액과 동전 개수를 추가
                    queue.offer(new int[]{nextCoin, current[1] + 1});
                    visited[nextCoin] = true;   // 방문 표시 추가. 이로써 같은 금액은 다시 반복해서 탐색하지 않는다.
                }
            }
        }
        return -1;  // 큐가 빌때까지 탐색했는데도 정답이 없음 => 불가능한 금액
    }
}
