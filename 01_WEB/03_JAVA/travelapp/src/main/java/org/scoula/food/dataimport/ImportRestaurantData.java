package org.scoula.food.dataimport;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.scoula.database.JDBCUtil;
import org.scoula.food.dao.RestaurantDao;
import org.scoula.food.dao.RestaurantDaoImpl;
import org.scoula.food.domain.RestaurantVO;

import java.io.*;
import java.util.*;

public class ImportRestaurantData {
    public static void main(String[] args) throws CsvValidationException, IOException {
        RestaurantDao dao = new RestaurantDaoImpl();

        List<RestaurantVO> restaurants = new CsvToBeanBuilder<RestaurantVO>(new FileReader("restaurant.csv"))
            .withType(RestaurantVO.class)
            .build()
            .parse();

        restaurants.forEach(res -> {
            dao.insert(res);
            System.out.println(res);
        });

        JDBCUtil.close();
    }
}
