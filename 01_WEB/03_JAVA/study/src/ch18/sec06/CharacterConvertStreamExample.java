package ch18.sec06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class CharacterConvertStreamExample {
    public static void main(String[] args) throws Exception {
        write("문자 변환 스트림을 사용합니다.");

        // 저장된 내용을 다시 읽어와서 출력
        String data = read();
        System.out.println(data);
    }

    // 문자열을 UTF-8로 인코딩하여 파일에 저장
    public static void write(String str) throws Exception {
        OutputStream os = new FileOutputStream("C:/test/test.txt");
        // 바이트 -> 문자 스트림 변환
        Writer writer = new OutputStreamWriter(os, "UTF-8");

        writer.write(str);
        writer.flush();
        writer.close();
    }

    // 파일에서 UTF-8로 디코딩된 문자열 읽기
    public static String read() throws Exception {
        InputStream is = new FileInputStream("C:/test/test.txt");
        // 바이트 -> 문자 스트림 변환
        Reader reader = new InputStreamReader(is, "UTF-8");
        
        char[] data = new char[100];
        int num = reader.read(data);    // 최대 100자 읽기
        reader.close();
        
        // 읽은 문자 수만큼 문자열 생성
        String str = new String(data, 0, num);
        return str;
    }
}
