package org.exam.domain;

public class Dog {
    private String name;
    private String breed;

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return "[Dog] 이름: " + name + ", 견종: " + breed;
    }
}
