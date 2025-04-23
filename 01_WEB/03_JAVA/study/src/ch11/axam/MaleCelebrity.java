package ch11.axam;

import java.util.Arrays;
import java.util.Objects;

public class MaleCelebrity implements Celebrity{
    private String name;
    private String[] list;

    public MaleCelebrity(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MaleCelebrity that)) return false;
        return Objects.equals(name, that.name) && Objects.deepEquals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(list));
    }
}
