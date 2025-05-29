package org.scoula.food.dataimport;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.scoula.database.JDBCUtil;
import org.scoula.food.dao.RestaurantDao;
import org.scoula.food.dao.RestaurantDaoImpl;
import org.scoula.food.domain.RestaurantReviewVO;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ImportReviewData {
    public static void main(String[] args) throws CsvValidationException, IOException {
        RestaurantDao dao = new RestaurantDaoImpl();

        List<RestaurantReviewVO> review = new CsvToBeanBuilder<RestaurantReviewVO>(new FileReader("reviews_pokemon.csv"))
            .withType(RestaurantReviewVO.class)
            .build()
            .parse();

        review.forEach(rev -> {
            dao.insertReview(rev);
            System.out.println(rev);
        });

        JDBCUtil.close();
    }
}
