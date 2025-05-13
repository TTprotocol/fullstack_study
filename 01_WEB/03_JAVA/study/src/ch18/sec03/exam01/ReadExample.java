package ch18.sec03.exam01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {
    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("C:/test/test1.db")) {
            while (true) {
                // 1바이트씩 읽기
                int data = is.read();
                // 파일 끝에 도달했으면 종료
                if (data == -1) break;
                // 읽은 바이트 값 출력
                System.out.println(data);
            }
        }catch (FileNotFoundException e) {
            // 파일이 존재하지 않을 경우 예외 처리
            e.printStackTrace();
        } catch (IOException e) {
            // 입출력 중 에러 발생 시 예외 처리
            e.printStackTrace();
        }
    }
}
