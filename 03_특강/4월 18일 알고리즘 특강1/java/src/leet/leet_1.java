package leet;

import java.util.*;

// leet 1번. Two Sum
public class leet_1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] answer = {};
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hash.isEmpty()) hash.put(target - nums[i], i);
            else {
                if(hash.containsKey(nums[i])) answer = new int[]{hash.get(nums[i]), i};
                else hash.put(target - nums[i], i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        int target = 6;

        int[] result = twoSum(nums, target);

        // 배열 출력 (배열은 그냥 출력하면 주소가 나오므로 Arrays.toString 사용)
        System.out.println("결과: " + Arrays.toString(result));
    }

}