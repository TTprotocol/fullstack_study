package org.scoula.travel;

import com.opencsv.bean.CsvToBeanBuilder;
import org.scoula.travel.domain.TravelVO;

import java.io.FileReader;
import java.util.List;

public class CSVTest2 {
    public static void main(String[] args) throws Exception{
        // csv 파일을 TravelVO 리스트로 매핑
        // csv 파일 헤더명과 TravelVO 필드명이 일치해야 함
        List<TravelVO> travels = new CsvToBeanBuilder<TravelVO>(new FileReader("travel.csv"))
            .withType(TravelVO.class)   // TravelVO 타입으로 변경
            .build()    // 빌드
            .parse();   // List로 파싱

        travels.forEach(System.out::println);
    }
}
