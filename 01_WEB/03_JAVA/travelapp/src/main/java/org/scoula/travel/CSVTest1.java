package org.scoula.travel;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class CSVTest1 {
    public static void main(String[] args) throws Exception{
        // csv 파일 가져오기
        CSVReader csvReader = new CSVReader(new FileReader("travel.csv"));
        String[] line;

        while((line = csvReader.readNext()) != null) {  // 마지막까지 csv 내용을 가져온다.
            System.out.println(String.join(",", line)); // 배열을 중간에 ,로 합쳐서 반환
        }
    }
}
