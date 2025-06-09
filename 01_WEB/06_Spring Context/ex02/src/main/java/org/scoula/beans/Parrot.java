package org.scoula.beans;

public class Parrot {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String neme) {
        this.name = neme;
    }

    @Override
    public String toString() {
        return "Parrot : " + name;
    }
}
