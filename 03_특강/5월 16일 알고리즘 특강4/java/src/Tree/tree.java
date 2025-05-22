package Tree;

import java.util.*;

class Node {
    int value;  // 노드의 값 
    List<Node> children;    // 자식 노드

    // 노드 생성
    Node(int value) {
        this.value = value;
        this.children = new ArrayList<Node>();
    }
}

public class tree {
    public static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> q = new ArrayDeque<>(); // 노드를 저장하는 큐 생성
        q.add(root);    // 큐에 루트 노드 저장

        // 트리를 순회하며 각 노드의 값을 출력
        while (!q.isEmpty()) {
            Node curNode = q.remove();
            System.out.println(curNode.value);

            // 현재 노드의 자식 노드들을 차례로 큐에 저장 => bfs 방식
            for (Node child : curNode.children) q.add(child);
        }
    }

    public static void main(String[] args) {
        // 트리 노드 생성
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        root.children.add(node2);
        root.children.add(node3);
        node2.children.add(node4);
        node2.children.add(node5);

        levelOrder(root);
    }
}
