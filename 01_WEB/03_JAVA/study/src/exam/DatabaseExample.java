package exam;

public class DatabaseExample {
    public static void main(String[] args) {
        Database instance = Database.getInstance();

        String db = instance.connect();
        System.out.println("데이터베이스 : " + db);
        instance.close();
    }
}
