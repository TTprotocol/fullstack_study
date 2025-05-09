package leet200;

// leetcode 200번 Number of Islands
// https://leetcode.com/problems/number-of-islands/description/
public class solution {
    public int numIslands(char[][] inputGrid) {
        char[][] grid = inputGrid;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        int count = 0;

        // 모든 노드를 순회하면서 DFS 실행
        for (int r = 0; r < rowLen; r++) {
            for (int c = 0; c < colLen; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    dfs(grid, r, c, visited); // 또는 bfs(r, c)
                    count++; // 네트워크 개수 증가
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int r, int c, boolean[][] visited) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        if (r < 0 || c < 0 || r >= rowLen || c >= colLen || grid[r][c] != '1' || visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        dfs(grid, r - 1, c, visited);
        dfs(grid, r + 1, c, visited);
        dfs(grid, r, c - 1, visited);
        dfs(grid, r, c + 1, visited);
    }

    public static void main(String[] args) {
        solution test = new solution();

        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
        };

        int answer = test.numIslands(grid);
        System.out.println(answer);
    }
}
