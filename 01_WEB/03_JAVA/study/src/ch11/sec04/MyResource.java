package ch11.sec04;

public class MyResource implements AutoCloseable {
    private String name;

    public MyResource(String name) {
        this.name = name;
        System.out.println("[MyResource(" + name + ") 열기]");
    }

    public String read1() {
        System.out.println("[MyResource(" + name + ") 읽기]");
        return "100";
    }

    public String read2() {
        System.out.println("[MyResource(" + name + ") 읽기]");
        return "abc";
    }

    // AutoCloseable의 close() 메소드 필수 구현해야 함 - 리소스 닫기
    @Override
    public void close() throws Exception {
        System.out.println("[MyResource(" + name + ") 닫기]");
    }
}
