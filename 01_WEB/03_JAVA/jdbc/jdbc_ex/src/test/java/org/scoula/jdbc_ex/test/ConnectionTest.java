package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    @Test   // 단위 테스트 사용
    @DisplayName("jdbc_ex 데이터베이스에 접속한다.")   // 테스트명 설정
    public void testConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");  // JDBC 드라이버 로드
        // 데이터베이스 연결을 위한 사용자 설정
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc_ex";
        String id = "scoula";
        String password = "1234";
        // DriverManager를 사용하여 데이터베이스 연결 객체를 생성
        Connection conn = DriverManager.getConnection(url, id, password);
        System.out.println("DB 연결 성공"); // 연결 성공 메시지 출력
        conn.close();   // 데이터베이스 연결을 닫음
    }
    
    @Test
    @DisplayName("jdbc_ex에 접속한다.(자동 닫기)")
    public void testConnection2() throws SQLException {
        try(Connection conn = JDBCUtil.getConnection()) {
            System.out.println("DB 연결 성공");
        }
    }
}
