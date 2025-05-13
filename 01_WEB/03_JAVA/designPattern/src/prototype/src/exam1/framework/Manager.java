package exam1.framework;

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
}
