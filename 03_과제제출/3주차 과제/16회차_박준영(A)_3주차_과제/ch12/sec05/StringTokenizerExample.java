package ch12.sec05;

import java.util.StringTokenizer;

public class StringTokenizerExample {
    public static void main(String[] args) {
        // 1, split() 메소드를 활용한 문자열 분리
        String data1 = "홍길동&이수홍,박연수";
        String[] arr = data1.split("&|,");  // 정규표현식 사용

        for (String token : arr) {
            System.out.println(token);
        }
        System.out.println();

        // 2. StirngTokenizer 클래스를 이용한 문자열 분리
        String data2 = "홍길동/이수홍/박연수";
        
        // 구분자 "/"로 분리해서 StringTokenizer 객체 생성
        StringTokenizer st = new StringTokenizer(data2, "/");

        while(st.hasMoreTokens()) { // 토큰이 남아있는지 확인
            String token = st.nextToken();  // 다음 토큰 꺼내기
            System.out.println(token);
        }
    }
}
