package Exam;

import java.util.*;

public class exam1 {
    public static int solution(int n, int[][] computers) {
        int answer = 0; // 정답

        List<List<Integer>> graph = graph(computers);   // 주어진 computers 연결을 그래프로 변환
        boolean[] visited = new boolean[n]; // 방문 여부를 저장하는 boolean 배열

        // dfs를 수행하는 반복문. 0에서부터 모든 노드를 순회하며 네트워크에 연결되어 있는지를 확인한다.
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {  // 방문 여부 확인
                dfs(graph, visited, i); // dfs 호출
                answer++;   // dfs 호출이 완료되고 나면 answer + 1.
            }
        }

        return answer;
    }

    // 주어진 computers 배열을 graph로 변환하는 작압.
    public static List<List<Integer>> graph(int[][] computers) {
        List<List<Integer>> array = new ArrayList<>();  // 그래프를 위한 ArrayList

        for (int i = 0; i < computers.length; i++) {    // 모든 노드를 순회한다.
            List<Integer> temp = new ArrayList<>();     // ArrayList에 저장하기 위한 Integer List.
            for(int j = 0; j < computers.length; j++) { // 2중 배열의 내용을 꺼내어 새로운 List로 만든다.
                if (i != j && computers[i][j] != 0) temp.add(j);    //
            }
            array.add(temp);    // 리스트 저장
        }
        System.out.println(array);
        return array;   // array 반환
    }

    // dfs 깊이탐색 호출문 정의
    public static void dfs(List<List<Integer>> graph, boolean[] visited, int curNode) {
        visited[curNode] = true;    // 현재 방문한 노드를 방문 처리한다,

        // 요소의 노드들을 모두 돌면서, 아직 방문하지 않았다면 다시 dfs를 그래프를 호출해준다.
        for (int nextNode : graph.get(curNode)) {
            if (!visited[nextNode]) {
                dfs(graph, visited, nextNode); //아직 방문하지 않은 노드를 다시 큐에
            }
        }
    }

    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int answer = solution(3, computers);
        System.out.println(answer);
    }
}

