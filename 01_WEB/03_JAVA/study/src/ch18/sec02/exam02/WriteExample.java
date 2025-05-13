package ch18.sec02.exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args) {
        try (OutputStream os = new FileOutputStream("C:/test/test2.db")) {
            // 파일에 저장할 바이트 배열 생성
            byte[] array = {65, 66, 67, 68, 69};

            // 바이트 배열 전체를 파일에 한 번에 출력
//            os.write(array);

            // 배열 인덱스 1부터 3개의 바이트 출력 (66, 67, 68)
            os.write(array, 1, 3);
        } catch (IOException e) {
            // 예외 발생 시 오류 내용 출력
            e.printStackTrace();
        }
    }
}
