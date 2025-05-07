package add;

public class MyLinkedList<E> {
    // 제네릭 클래스 Node
    private static class Node<E> {
        E data; // 실제 값
        Node<E> next;    // 다음 노드

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> head;   // 첫 번째 노드
    private int size;   // 노드 개수

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // 맨 앞에 요소 추가
    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value);
        newNode.next = head;    // 기존 헤드를 새로운 노드의 다음 값으로 지정
        head = newNode; // 새로운 노드를 헤드로 지정
        size++;
    }

    // 맨 뒤에 요소 추가
    public void addLast(E value) {
        Node<E> newNode = new Node<>(value);
        if (head == null) head = newNode;
        else {
            Node<E> current = head;
            while (current.next != null) {   // 해당 값이 마지막인지 체크
                current = current.next; // 계속 다음 값을 찾아서 이동함.
            }
            current.next = newNode;
        }
        size++;
    }

    // index 위치에 값 추가
    public void add(int index, E value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) addFirst(value);
        else {
            Node<E> newNode = new Node<>(value);
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;   // 찾는 인덱스 노드 앞까지 순회
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }

    }
}
