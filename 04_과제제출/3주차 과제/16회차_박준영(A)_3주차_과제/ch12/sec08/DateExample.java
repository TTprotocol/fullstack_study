package ch12.sec08;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
    public static void main(String[] args) {
        // 현재 날짜와 시간 객체 생성
        Date now = new Date();
        String strNow1 = now.toString();
        System.out.println(strNow1);

        //날짜 포맷 저장
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String strNow2 = sdf.format(now);
        System.out.println(strNow2);

    }
}
