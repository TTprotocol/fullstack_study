package prog178139;

import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 미로 탈출
// https://campus.programmers.co.kr/tryouts/178139/challenges?language=java
public class solution {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int rowLen;
    static int colLen;

    public int solution(String[] maps) {
        int answer;

        rowLen = maps.length;
        colLen = maps[0].length();
        boolean[][] visited1 = new boolean[rowLen][colLen];
        boolean[][] visited2 = new boolean[rowLen][colLen];

        int startRow = 0;
        int startCol = 0;

        for (int i = 0; i < rowLen; i++) {
            int colTemp = 0;
            for (String s : maps[i].split("")) {
                if (s.equals("S")) {
                    startRow = i;
                    startCol = colTemp;
                    break;
                } else {
                    colTemp++;
                }
            }
        }

        int[] startToLever = bfs(maps, startRow, startCol, 0, 'L', visited1);
        if (startToLever[2] == -1) return -1;

        int[] leverToEnd = bfs(maps, startToLever[0], startToLever[1], 0, 'E', visited2);
        if (leverToEnd[2] == -1) return -1;

        answer = startToLever[2] + leverToEnd[2];

        return answer;
    }

    public static int[] bfs(String[] maps, int r, int c, int pathLen, char to, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c, pathLen});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            int curPathLen = cur[2];

            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < rowLen && nextCol < colLen) {

                    String mapRow = maps[nextRow];
                    char mapUnit = mapRow.charAt(nextCol);

                    if (mapUnit == to) return new int[]{nextRow, nextCol, curPathLen + 1};
                    if (!visited[nextRow][nextCol] && mapUnit != 'X') {
//                        System.out.println("nextRow : " + nextRow + ", nextCol: " + nextCol + ", curPathLen + 1 : " + (curPathLen + 1));
                        queue.offer(new int[]{nextRow, nextCol, curPathLen + 1});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }

        return new int[]{-1, -1, -1};
    }

    public static void main(String[] args) {
        solution sol = new solution();

        String[] maps = {
            "SOOOOOOX",
            "XXXXXXOX",
            "XOXLXOOX",
            "XOXXXOOX",
            "XOOOOOOX",
            "XOXOXOXX",
            "XOXOXOEX",
            "XXXXXXXX"
        };

        int answer = sol.solution(maps);
        System.out.println(answer);
    }
}
