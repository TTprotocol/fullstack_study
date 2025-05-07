package ch15.sec03.exam03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        //HashSet 컬렉션 생성
        Set<String> set = new HashSet<String>();

        //객체 추가
        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Spring");

        Iterator<String> iterator = set.iterator();

        // hasNext : 다음 값이 있는지 확인
        while(iterator.hasNext()) {
            // next : 다음 값을 들고오는 메서드
            String element = iterator.next();
            System.out.println(element);
            // remove : 가져온 값을 컬렉션에서 제거
            if (element.equals("JSP")) iterator.remove();
        }
        System.out.println();

        // 객체 제거
        set.remove("JDBC");

        // 향상된 for문
        for (String element : set) {
            System.out.println(element);
        }
        System.out.println();
    }
}
