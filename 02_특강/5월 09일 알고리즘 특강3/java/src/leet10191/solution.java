package leet10191;

import java.util.LinkedList;
import java.util.Queue;

// leetcode 1091번 Shortest Path in Binary Matrix
// https://leetcode.com/problems/shortest-path-in-binary-matrix/submissions/1629056161/
public class solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int len = grid.length;
        if (grid[0][0] != 0 || grid[len - 1][len - 1] != 0) return -1;

        int[][] directions = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1},
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        boolean[][] visited = new boolean[len][len];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int pathLen = current[2];

            if (row == len - 1 && col == len - 1) {
                return pathLen;
            }

            for (int[] d : directions) {
                int nearRow = row + d[0];
                int nearCol = col + d[1];

                if (
                    nearRow >= 0 &&
                        nearCol >= 0 &&
                        nearRow < len &&
                        nearCol < len &&
                        grid[nearRow][nearCol] == 0 &&
                        !visited[nearRow][nearCol]
                ) {
                    visited[nearRow][nearCol] = true;
                    queue.offer(new int[]{nearRow, nearCol, pathLen + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        solution sol = new solution();

        int[][] grid = {
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 0}
        };

        int anwser = sol.shortestPathBinaryMatrix(grid);
        System.out.println(anwser);
    }
}
