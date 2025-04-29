package ch13.sec03.exam01;

public class GenericExample {
    // boxing 제너릭 메서드 정의 (매개변수와 Box에 넣어주는 타입이 일치해야 한다)
    // static <T> : 메서드 타입 T
    // Box<T> 의 T : 함수 반환값의 타입 T (정확히는 T 타입을 담는 Box)
    // boxing(T t) : 매개변수의 타입 T
    public static <T> Box<T> boxing(T t) {
        Box<T> box = new Box<T>();
        box.set(t);
        return box;
    }

    public static void main(String[] args) {
        Box<Integer> box1 = boxing(100);
        int intValue = box1.get();
        System.out.println(intValue);

        Box<String> box2 = boxing("홍길동");
        String strValue = box2.get();
        System.out.println(strValue);

    }
}
