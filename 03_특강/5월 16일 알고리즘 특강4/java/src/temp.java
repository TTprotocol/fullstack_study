
import java.util.*;

public class temp {
    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        System.out.println("fees : " + Arrays.toString(fees));
        System.out.println("records : " + Arrays.toString(records));

        Map<String, Integer> map = new HashMap<>();


        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            if (record[2] == "IN") {
                String[] time = record[0].split(":");
                int inTime = (Integer.parseInt(time[0]) * 60) + Integer.parseInt(time[1]);

                System.out.println("inTime : " + inTime);

                map.put(record[1], inTime);
            }
        }

        System.out.println("mpa : " + map);


        return answer;
    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN"};
        int[] answer = solution(fees, records);

        System.out.println("answer : " + Arrays.toString(answer));
    }
}
