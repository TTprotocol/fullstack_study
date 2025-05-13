package ch18.sec07.exam02;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadLineExample {
    public static void main(String[] args) throws Exception{
        // BufferedReader를 이용한 성능 향상된 텍스트 파일 읽기
        BufferedReader br = new BufferedReader(
            new FileReader("src/ch18/sec07/exam02/ReadLineExample.java")
        );

        int lineNo = 1; // 줄 번호
        while(true) {
            String str = br.readLine(); // 한 줄 읽기
            if (str == null) break; // 파일 끝(EOF)이라면 종료
            System.out.println(lineNo + "\t" + str);    // 줄 번호와 내용 출력
            lineNo++;
        }

        br.close();
    }
}
