package add;

public class MyArrayList<E> {
    private E[] element;
    private int size;   // 현재 저장된 요소 수

    private static final int DEFULT_CAPATICY = 10;

    public MyArrayList() {
        element = (E[]) new Object[DEFULT_CAPATICY];
        size = 0;
    }

    // 내부 배열 크기 늘리기
    private void ensureCapacity() {
        if (size >= element.length) {
            int newCapacity = element.length * 2;
            E[] newElement = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newElement[i] = element[i];
            }
            element = newElement;

        }
    }

    // 맨 뒤에 요소 추가
    public void add(E value) {
        ensureCapacity();
        element[size++] = value;    // 요소 추가 후에 size 늘리기
    }
    
    // 특정 인덱스에 요소 삽입
    public void add(int index, E value) {
        if (index < 0 || index > size) {    // 인덱스 유효성 체크
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity();
        for (int i = size; i > index; i--) {
            element[i] = element[i - 1];    // 뒤에서부터 앞의 요소를 가져온다
        }
        element[index] = value;
        size++;
    }

    // 인덱스로 요소 조회
    public E get(int index) {
        if (index < 0 || index > size) {    // 인덱스 유효성 체크
            throw new IndexOutOfBoundsException();
        }
        return element[index];
    }
    
    // 인덱스로 요소 삭제
    public E remove(int index) {
        if (index < 0 || index > size) {    // 인덱스 유효성 체크
            throw new IndexOutOfBoundsException();
        }
        E removeValue = element[index];
        for (int i = index; i < size - 1; i++) {
            element[i] = element[i + 1];    // 앞에서부터 뒤의 값을 당겨온다
        }
        element[size - 1] = null;
        size--;
        return removeValue;
    }

    // 현재 크기 반환
    public int size() {
        return size;
    }

    // 비어있는지 확인
    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for(int i = 0; i < size; i++) {
            element[i] = null;
        }
        size = 0;
    }

}
