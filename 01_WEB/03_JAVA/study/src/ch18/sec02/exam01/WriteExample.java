package ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args) {
//        try {
//            // 출력 스트림 생성 : 파일에 데이터를 출력할 수 있도록 연결
//            OutputStream os = new FileOutputStream("C:/test/test1.db");
//
//            // 저장할 바이트 데이터
//            byte a = 10;
//            byte b = 20;
//            byte c = 30;
//
//            // 바이트 단위로 파일에 쓰기
//            os.write(a);
//            os.write(b);
//            os.write(c);
//
//            // 출력 버퍼 비우기
//            os.flush();
//
//            // 스트림 닫기 (리소스 해제)
//            os.close();
//        } catch (IOException e) {
//            // 예외 처리 (파일 사용시 IOException 필수 처리)
//            e.printStackTrace();
//        }

        // try-with-resources 구문 : os는 try 블록이 끝나면 자동으로 close 됨.
        try (OutputStream os = new FileOutputStream("C:/test/test1.db")) {
            byte a = 65;
            byte b = 66;
            byte c = 67;

            os.write(a);
            os.write(b);
            os.write(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
