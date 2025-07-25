package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrudTest2 {
    Connection conn = JDBCUtil.getConnection();

    @AfterAll
    static void tearDown() {
        JDBCUtil.close();
    }

    @Test
    @DisplayName("insertUser 테스트")
    @Order(1)
    public void insertUser() throws SQLException {
        String sql = "insert into users values (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "scoula_Test");
            pstmt.setString(2, "scoula_Test");
            pstmt.setString(3, "스콜라_Test");
            pstmt.setString(4, "USER");

            int count = pstmt.executeUpdate();
            assertEquals(1, count);
        }
    }

    @Test
    @DisplayName("user 추출")
    @Order(2)
    public void selectUser() throws SQLException {
        String sql = "select * from users";
        try (
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ) {
            while(rs.next()) {
                System.out.println(rs.getString("name"));
            }
        }
    }

    @Test
    @DisplayName("특정 user 검색한다.")
    @Order(3)
    public void selectUserById() throws SQLException {
        String userid = "scoula";
        String sql = "select * from users where id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userid);
            try (ResultSet rs = stmt.executeQuery()) {
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
        String sql = "update users set name = ? where id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "스콜라 수정");
            stmt.setString(2, userid);
            int count = stmt.executeUpdate();
            assertEquals(1, count);
        }
    }

    @Test
    @DisplayName("지정한 사용자를 삭제한다.")
    @Order(5)
    public void deleteUser() throws SQLException {
        String userid = "scoula";
        String sql = "delete from users where id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userid);
            int count = stmt.executeUpdate();
            Assertions.assertEquals(1, count);
        }
    }
}
