package org.scoula.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    static Connection conn = null;

    /**
     * 커넥션 객체는 여러개 있을 필요가 없음 => 싱글톤 패턴
     * 그러나 완전히 같지는 않다.
     * 원래 싱글톤은 JDBCUtil 클래스의 객체가 1개만 있는 것이기 때문.
     */
    // 정적 초기화 블록을 사용하여 JDBC 드라이버를 로드하고 데이터베이스 연결을 설정
    static {
        try {
            // Properties 객체를 생성하고 appllication.properties 파일을 로드
            Properties properties = new Properties();
            properties.load(JDBCUtil.class.getResourceAsStream("/application.properties"));

            // 프로퍼티 파일에서 드라이버, URL, 사용자 ID, 비밀번호를 가져옴.
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String id = properties.getProperty("id");
            String password = properties.getProperty("password");

            // MySql JDBC 드라이버를 로드
            Class.forName(driver);
            conn = DriverManager.getConnection(url, id, password);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 데이터베이스 연결 객체를 반환하는 메서드
    public static Connection getConnection() {
        return conn;
    }

    // 연결한 데이터베이스 객체를 닫는다.
    public static void close() {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
