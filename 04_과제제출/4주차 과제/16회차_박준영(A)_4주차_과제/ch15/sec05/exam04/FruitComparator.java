package ch15.sec05.exam04;

import java.util.Comparator;

public class FruitComparator implements Comparator<Fruit>{
    // Comparator를 구현하려면 필수로 만들어야 하는 메서드
    // compare : 외부에서 받아온 2개의 값 비교
    @Override
    public int compare(Fruit o1, Fruit o2) {
        if (o1.prices < o2.prices) return -1;
        else if (o1.prices == o2.prices) return 0;
        else return 1;
    }
}
