package ch15.sec05.exam03;

public class Person implements Comparable<Person> {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Comparable을 구현하려면 필수로 만들어야 하는 메서드
    // compareTo : 자기 자신과 외부에서 받아온 값 비교
    @Override
    public int compareTo(Person o) {
        if (age < o.age) return -1;
        else if (age == o.age) return 0;
        else return 1;
    }
}
