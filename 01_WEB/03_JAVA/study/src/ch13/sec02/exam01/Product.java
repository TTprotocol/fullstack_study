package ch13.sec02.exam01;

// 제네릭 타입
// 타입 파라미터를 2개 사용할 경우 두 개의 알파벳 지정
public class Product<K,  M> {
    // 타입 파라미터는 필드, 리턴값, 매개변수 타입으로 모두 사용가능
    
    // 타입 파라미터를 필드 타입으로 사용
    private K kind;
    private M model;

    // 타입 파라미터를 리턴 타입과 매개 변수 타입으로 사용
    public K getKind() {
        return this.kind;
    }

    public M getModel() {
        return this.model;
    }

    public void setKind(K kind) {
        this.kind = kind;
    }

    public void setModel(M model) {
        this.model = model;
    }
}
