package ch18.sec04.exam01;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample {
    public static void main(String[] args) {
        try (Writer writer = new FileWriter("C:/test/test.txt")) {
            // 1문자씩 출력
            char a = 'A';
            writer.write(a);
            char b = 'B';
            writer.write(b);

            // char 배열 출력
            char[] arr = {'C', 'D', 'E'};
            writer.write(arr);

            // 문자열 출력
            writer.write("FGH");

            // 버퍼에 남아있던 테이터 면전에서 문자열 출력하고 비우기
            writer.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
