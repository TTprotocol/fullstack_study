package org.scoula.food.dao;

import org.scoula.database.JDBCUtil;
import org.scoula.food.domain.RestaurantReviewVO;
import org.scoula.food.domain.RestaurantVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RestaurantDaoImpl implements RestaurantDao {
    Connection conn = JDBCUtil.getConnection();

    @Override
    public void insert(RestaurantVO restaurant) {
        String sql = "insert into tbl_restaurant(name, category, address, description) values(?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, restaurant.getName());
            pstmt.setString(2, restaurant.getCategory());
            pstmt.setString(3, restaurant.getAddress());
            pstmt.setString(4, restaurant.getDescription());

            int count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertReview(RestaurantReviewVO review) {
        String sql = "INSERT INTO tbl_restaurant_review(restaurant_id, writer, content, score) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, review.getRestaurantId());
            pstmt.setString(2, review.getWriter());
            pstmt.setString(3, review.getContent());
            pstmt.setLong(4, review.getScore());

            int count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
