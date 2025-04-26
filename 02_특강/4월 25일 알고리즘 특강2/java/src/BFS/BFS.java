package BFS;

import java.util.*;

public class BFS {
    public void bfs(List<List<Integer>> graph, int startVertex) {
//        Deque<Integer> que = new ArrayDeque<>();
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        que.add(startVertex);
//        map.put(startVertex, 1);
//
//        while(!que.isEmpty()) {
//            int nowNode = que.poll();
//            for (List<Integer> nextNode : graph) {
//
//            }
//        }


        // 시작점
        Queue<Integer> queue = new ArrayDeque<>();  // int 큐 생성
        // 방문한 노드를 기록하기 위한 배열(hashmap)

        queue.add(startVertex);

    }

    public void solve(List<List<Integer>> graph) {
        bfs(graph, 0);
    }

    // 실행용 메소드
    public static void main(String[] args) {
        (new BFS()).solve(makeGraph());
    }

    public static List<List<Integer>> makeGraph() {
        return new ArrayList<>() {{
            add(List.of(1, 3, 6));
            add(List.of(0, 3));
            add(List.of(3));
            add(List.of(0, 1, 2, 7));
            add(List.of(5));
            add(List.of(4, 6, 7));
            add(List.of(0, 5));
            add(List.of(3, 5));
        }};
    }

}
