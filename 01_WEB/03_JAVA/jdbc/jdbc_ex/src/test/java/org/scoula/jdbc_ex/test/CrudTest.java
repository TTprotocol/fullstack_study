package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)   // 테스트 메서드의 실행 순서를 지정
public class CrudTest {
    Connection conn = JDBCUtil.getConnection();

    @AfterAll   // 모든 테스트 후에 실행
    static void tearDown() {
        JDBCUtil.close();
    }

    @Test
    @DisplayName("새로운 user를 등록한다.")
    @Order(1)   // 테스트 실행 순서를 지정
    public void insertUser() throws SQLException {
        // 사용자 정보를 테이터베이스에 삽입하는 sql 쿼리
        String sql = "insert into users values(?, ?, ?, ?)"; // 데이터 부분을 변수처리함.

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // sql 쿼리의 매개변수 설정
            pstmt.setString(1, "scoula");
            pstmt.setString(2, "scoula3");
            pstmt.setString(3, "스콜라");
            pstmt.setString(4, "USER");

            int count = pstmt.executeUpdate();
            assertEquals(1, count);

        }
    }

    @Test
    @DisplayName("user 목록을 추출한다.")
    @Order(2)
    public void selectUser() throws SQLException {
        // 모든 사용자 정보를 조회하는 sql 쿼리
        String sql = "select * from users";
        try (
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ) {
            // 결과 집합(ResultSet)
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        }
    }

    @Test
    @DisplayName("특정 user 검색한다.")
    @Order(3)
    public void selectUserById() throws SQLException {
        String userid = "scoula";   // 검색할 사용자 id
        // 특정 사용자 정보를 조회하는 sql 쿼리
        String sql = "select * from users where id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            // sql 쿼리의 매개변수 설정
            stmt.setString(1, userid);
            try (ResultSet rs = stmt.executeQuery()) {
                // 결과 집합(ResultSet)에서 데이터를 읽어와서 출력
                if (rs.next()) {
                    System.out.println(rs.getString("name"));
                } else {
                    throw new SQLException("scoula not found");
                }
            }
        }
    }

    @Test
    @DisplayName("특정 user를 수정한다")
    @Order(4)
    public void updateUser() throws SQLException {
        String userid = "scoula";
        // 특정 사용자의 정보를 수정하는 sql 쿼리
        String sql = "update users set name = ? where id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            // sql 쿼리의 매개변수 설정
            stmt.setString(1, "스콜라 수정");
            stmt.setString(2, userid);
            int count = stmt.executeUpdate();
            // 수정된 행의 수가 1개인지 확인
            assertEquals(1, count);
        }
    }

    @Test
    @DisplayName("지정한 사용자를 삭제한다.")
    @Order(5)
    public void deleteUser() throws SQLException {
        String userid = "scoula";
        // 특정 사용자를 삭제하는 sql 쿼리
        String sql = "delete from users where id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userid);
            int count = stmt.executeUpdate();
            Assertions.assertEquals(1, count);
        }
    }
}
