package ch15.sec05.exam04;

import java.util.TreeSet;

public class ComparatorExample {
    public static void main(String[] args) {
        // Fruit이 Comparable 구현을 하지 않았기 때문에 Comparator 필요
        TreeSet<Fruit> treeSet = new TreeSet<Fruit>(new FruitComparator());

        // compare에서 가격 기준으로 정렬
        treeSet.add(new Fruit("포도", 3000));
        treeSet.add(new Fruit("수박", 10000));
        treeSet.add(new Fruit("딸기", 6000));
        
        //객체를 하나씩 가져오기
        for (Fruit fruit : treeSet) {
            System.out.println(fruit.name + ":" + fruit.prices);
        }
    }
}
