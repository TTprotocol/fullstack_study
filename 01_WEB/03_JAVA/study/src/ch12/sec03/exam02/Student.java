package ch12.sec03.exam02;

public class Student {
    private int no;
    private String name;

    public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }

    // getter
    public int getNo() { return no; }

    // getter
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    @Override public int hashCode() {
        int hashCode = no + name.hashCode(); return hashCode;
    }

    @Override public boolean equals(Object obj) {
        if (obj instanceof Student target) {
            // 학번과 이름이 같으면 true
            return no == target.getNo() && name.equals(target.getName());
        }
        return false;
    }
}
