package ch15.sec04.exam01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        // 키 값이 중복되면 저장되지 않는다.
        map.put("신용권", 85);
        map.put("홍길동", 90);
        map.put("동장군", 80);
        map.put("홍길동", 95);
        System.out.println("총 Entry 수: " + map.size());
        System.out.println();

        String key = "홍길동";
        // get : 키로 값을 가져올 수 있는 메서드
        int value = map.get(key);
        System.out.println(key + ": " + value);
        System.out.println();

        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while (keyIterator.hasNext()) {
            String k = keyIterator.next();
            Integer v = map.get(k);
            System.out.println(k + " : " + v);
        }
        System.out.println();

        // entrySet : map의0 entry들을 Set 형태로 가져오는 메서드
        Set<Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Entry<String, Integer> entry = entryIterator.next();
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println(k + " : " + v);
        }
        System.out.println();

        // remove : key 값으로 엔트리를 삭제하는 메서드
        map.remove("홍길동");
        System.out.println("총 Entry 수: " + map.size());
        System.out.println();
    }
}
