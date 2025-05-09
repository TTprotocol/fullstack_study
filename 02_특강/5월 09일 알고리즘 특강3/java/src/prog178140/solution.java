package prog178140;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 거리두기 확인하기
// https://campus.programmers.co.kr/tryouts/178140/challenges?language=java
public class solution {

    static int rowLen;
    static int colLen;
    static int[] dr = {-1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int placeIndex = 0;

        for (String[] place : places) {
            rowLen = place.length;
            colLen = place[0].length();

            boolean isValid = true;
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < colLen; j++) {
                    String placeRow = place[i];
                    char placeUnit = placeRow.charAt(j);
                    if (placeUnit == 'P') {
                        if (bfs(place, i, j, 0) == -1) {
                            isValid = false;
                            break;
                        }
                    }
                }
                if (!isValid) break;
            }
            answer[placeIndex] = isValid ? 1 : 0;
            placeIndex++;
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static int bfs(String[] place, int r, int c, int pathLen) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {r, c, pathLen});
        boolean[][] visited = new boolean[5][5];
        visited[r][c] = true;

//        System.out.println("r : " + r + ", c : " + c);
//        System.out.println(Arrays.toString(place));

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curRow = current[0];
            int curCol = current[1];
            int curPathLen = current[2];

            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < rowLen && nextCol < colLen) {
                    String placeRow = place[nextRow];
                    char placeUnit = placeRow.charAt(nextCol);
//                    System.out.println("nextRow : " + nextRow + ", nextCol : " + nextCol + ", placeUnit : " + placeUnit);

                    if (!visited[nextRow][nextCol] && placeUnit != 'X') {
                        if (curPathLen + 1 <= 2 && placeUnit == 'P') return -1;
                        else {
                            queue.add(new int[] {nextRow, nextCol, curPathLen + 1});
                            visited[nextRow][nextCol] = true;
                        }
                    }
                }
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        solution sol = new solution();

        String[][] places = {
            {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"},
        };

        int[] answer = sol.solution(places);
    }
}
