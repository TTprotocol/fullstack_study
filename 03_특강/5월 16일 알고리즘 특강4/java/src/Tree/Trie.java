package Tree;

import java.util.HashMap; // 문자(char)와 자식 노드(TrieNode) 매핑을 위한 해시맵 사용
import java.util.Map;     // Map 인터페이스 사용

// TrieNode 클래스: 각 문자를 저장하고, 자식 노드를 가짐
class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>(); // 현재 노드의 자식 노드들
    boolean isEndOfWord = false; // 단어의 끝을 나타내는 플래그
}

public class Trie {
    private final TrieNode root = new TrieNode(); // 트리의 시작 지점

    // 단어 삽입 메서드
    public void insert(String word) {
        TrieNode node = root; // 루트 노드부터 시작
        for (char ch : word.toCharArray()) { // 단어의 각 문자에 대해 반복
            // 현재 문자 ch에 해당하는 자식 노드가 없으면 새로 생성하고 이동
            node = node.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        node.isEndOfWord = true; // 단어의 마지막 문자 노드 표시
    }

    // 완전 일치 검색 메서드
    public boolean search(String word) {
        TrieNode node = searchPrefix(word); // 단어를 구성하는 경로를 탐색
        return node != null && node.isEndOfWord; // 해당 경로가 존재하고 마지막 문자인 경우 true
    }

    // 접두사 검색 메서드
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null; // prefix 경로가 트라이 내에 존재하면 true
    }

    // 주어진 문자열의 경로를 따라가며 마지막 노드 반환
    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root; // 루트 노드부터 탐색 시작
        for (char ch : prefix.toCharArray()) { // 접두사의 각 문자에 대해 반복
            node = node.children.get(ch); // 현재 문자에 해당하는 자식 노드로 이동
            if (node == null) return null; // 중간에 노드가 없으면 null 반환
        }
        return node; // 모든 문자 탐색 성공 시 마지막 노드 반환
    }
}
