package strage;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Main randomseed1 randomseed2");
            System.out.println("Example: java Main 314 15");
            System.exit(0);
        }

        // 입력받은 시드값 파싱
        int seed1 = Integer.parseInt(args[0]);
        int seed2 = Integer.parseInt(args[1]);

        // 플레이어 생성
        Player player1 = new Player("Kim", new WinningStrategy(seed1));
        Player player2 = new Player("LEE", new WinningStrategy(seed2));

        // 만 번 반복
        for (int i = 0; i < 10000; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();

            if (nextHand1.isStrongerThan(nextHand2)) {
                // 플레이어1 승리
                System.out.println("Winner : " + player1);
                player1.win();
                player2.lose();
            } else if (nextHand2.isStrongerThan(nextHand1)) {
                // 플레이어2 승리
                System.out.println("Winner : " + player2);
                player1.lose();
                player2.win();
            } else {
                // 무승부
                System.out.println("Even...");
                player1.even();
                player2.even();
            }
        }

        // 결과 출력
        System.out.println("Total result");
        System.out.println(player1);
        System.out.println(player2);
    }
}
