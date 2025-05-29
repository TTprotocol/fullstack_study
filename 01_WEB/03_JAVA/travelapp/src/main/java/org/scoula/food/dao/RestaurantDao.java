package org.scoula.food.dao;

import org.scoula.food.domain.RestaurantReviewVO;
import org.scoula.food.domain.RestaurantVO;

public interface RestaurantDao {
    void insert(RestaurantVO restaurant);   // 한 건 저장

    void insertReview(RestaurantReviewVO review);   // 리뷰 한 건 저장
}
