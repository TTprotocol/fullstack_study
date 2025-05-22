package ch06.sec07.exam02;

public class KoreanExample {
    public static void main(String[] args) {
        Korean korean = new Korean("박자바", "011225-1234567");
        System.out.println("k1.nation" + korean.nation);
        System.out.println("k1.name" + korean.name);
        System.out.println("k1.ssn" + korean.ssn);

        Korean korean1 = new Korean("김자바", "930525-0654321");
        System.out.println("k2.nation" + korean1.nation);
        System.out.println("k2.name" + korean1.name);
        System.out.println("k2.ssn" + korean1.ssn);
    }
}
