package org.scoula.food.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantReviewVO {
    @CsvBindByName(column = "restaurant_id")
    private Long restaurantId;
    @CsvBindByName(column = "writer")
    private String writer;
    @CsvBindByName(column = "content")
    private String content;
    @CsvBindByName(column = "score")
    private Long score;
}
