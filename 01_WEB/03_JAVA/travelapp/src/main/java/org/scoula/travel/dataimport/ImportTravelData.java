package org.scoula.travel.dataimport;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.scoula.database.JDBCUtil;
import org.scoula.travel.dao.TravelDao;
import org.scoula.travel.dao.TravelDaoImpl;
import org.scoula.travel.domain.TravelVO;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ImportTravelData {
    public static void main(String[] args) throws CsvValidationException, IOException {
        TravelDao dao = new TravelDaoImpl();

        List<TravelVO> travels = new CsvToBeanBuilder<TravelVO>(new FileReader("travel.csv"))
            .withType(TravelVO.class)
            .build()
            .parse();

        travels.forEach(travel -> {
            System.out.println(travel);
            dao.insert(travel); // 실제 DB에 삽입 처리
        });

        JDBCUtil.close();
    }
}
