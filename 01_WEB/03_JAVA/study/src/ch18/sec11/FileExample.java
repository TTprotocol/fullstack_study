package ch18.sec11;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {
    public static void main(String[] args) throws Exception {
        // 1. File 객체 생성
        File dir = new File("src/ch18/sec11/images");
        File file1 = new File("src/ch18/sec11/file1.txt");
        File file2 = new File("src/ch18/sec11/file2.txt");
        File file3 = new File("src/ch18/sec11/file3.txt");

        // 2. 존재하지 않으면 디렉토리 또는 파일 생성
        if (dir.exists() == false) dir.mkdirs();
        if (file1.exists() == false) file1.createNewFile();
        if (file2.exists() == false) file2.createNewFile();
        if (file3.exists() == false) file3.createNewFile();

        // 3. src/ch18/sec11 폴더의 내용을 출력
        File temp = new File("src/ch18/sec11");
        File[] contents = temp.listFiles(); // 폴더 내의 전체 목록
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");

        for (File file : contents) {
            // 수정일자 출력
            System.out.printf("%-25s", sdf.format(new Date(file.lastModified())));

            // 디렉토리/파일 구분 출력
            if (file.isDirectory()) {
                System.out.printf("%-10s%-20s", "<DIR>", file.getName());
            } else {
                System.out.printf("%-10s%-20s", file.length(), file.getName());
            }
            System.out.println();
        }
    }
}
