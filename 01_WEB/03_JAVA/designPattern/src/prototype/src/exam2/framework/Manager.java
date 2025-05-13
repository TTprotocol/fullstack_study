package exam2.framework;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<String, Product> map = new HashMap<>();

    public void register(String name, Product p) {
        map.put(name, p);
    }

    public Product create(String name) {
        Product p = map.get(name);
        return p.createCopy();
    }

    public void printRegisteredStyles() {
        System.out.println("[등록된 스타일 목록]");
        map.forEach((s, p) -> {
            System.out.println("- " + s + " : " + p.toString());
        });
        System.out.println();
    }
}
