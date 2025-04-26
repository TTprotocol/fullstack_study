package Exam;

import java.util.*;

public class exam1 {
    public static int solution(int n, int[][] computers) {
        int answer = 0;

        List<List<Integer>> graph = graph(computers);
        boolean[] visited = new boolean[n];

        // System.out.println(graph);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                answer++;
            }
        }


        return answer;
    }

    public static List<List<Integer>> graph(int[][] computers) {
        List<List<Integer>> array = new ArrayList<>();

        for (int i = 0; i < computers.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < computers.length; j++) {
                if (i != j && computers[i][j] != 0) temp.add(j);
            }
            array.add(temp);
        }

        return array;
    }

    public static void dfs(List<List<Integer>> graph, boolean[] visited, int curNode) {
        visited[curNode] = true;

        for (int nextNode : graph.get(curNode)) {
            if (!visited[nextNode]) {
                dfs(graph, visited, nextNode);
            }
        }
    }

    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 1}};
        int answer = solution(4, computers);
        System.out.println(answer);
    }
}

