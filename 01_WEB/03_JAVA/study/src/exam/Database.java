package exam;

// 4월 16일 실습과제1
public class Database {
    private static final Database instance = new Database();
    private final String connection = "MySql";

    private Database() {
    }

    public static Database getInstance() {
        return instance;
    }

    public String connect() {
        System.out.println(connection + "에 연결합니다.");
        return connection;
    }

    public void close() {
        System.out.println(connection + "을 닫습니다.");
    }
}
