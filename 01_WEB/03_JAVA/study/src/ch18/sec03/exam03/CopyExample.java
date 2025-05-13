package ch18.sec03.exam03;

import java.io.*;

public class CopyExample {
    public static void main(String[] args) throws Exception {
        String originalFileName = "C:/test/test1.db";
        String targetFileName = "C:/test/test2.db";

        try (
            // 입력 스트림 : 원본 파일에서 읽기
            InputStream is = new FileInputStream(originalFileName);
            // 출력 스트림 : 대상 파일에 쓰기
            OutputStream os = new FileOutputStream(targetFileName);
        ) {
            // 1024 바이트 크기의 버퍼 배열 생성
            byte[] data = new byte[1024];
            while (true) {
                // 최대 1024 바이트 읽기
                int num = is.read(data);
                if (num == -1) break;
                // 읽은 만큼 대상 파일에 쓰기
                os.write(data, 0, num);
            }

            // 내부 버퍼 잔류 바이트 출력 (정리)
            os.flush();
            System.out.println("복사 완료");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
