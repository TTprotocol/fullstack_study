package Exam;

import java.util.*;

public class exam2 {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean answer = true;

        System.out.println("rooms : " + rooms);
        Set<Integer> visited = new HashSet<>();

        dfs(rooms, visited, 0);

        answer = rooms.size() == visited.size();

        return answer;
    }

    public static void dfs(List<List<Integer>> rooms, Set<Integer> visited, int curNode) {
        System.out.println(visited);
        visited.add(curNode);

        for (int nextNode : rooms.get(curNode)) {
            if (!visited.contains(nextNode)) {
                dfs(rooms, visited, nextNode);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>() {{
            add(List.of(1));
            add(List.of(2));
            add(List.of(3));
            add(List.of(0));
        }};
        boolean answer = canVisitAllRooms(rooms);
        System.out.println(answer);
    }
}

