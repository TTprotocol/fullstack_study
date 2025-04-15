package exam;

public class exam {
    public static void main(String[] args) {
//        for (int i = 0; i <= 10; i++) {
//            for (int j = 0; j <= 10; j++) {
//                if (((4 * i) + (5 * j)) == 60) System.out.println("x : " + i + ", y : " + j);
//            }
//        }

//        int[][] array = {
//                {95, 86},
//                {92, 92, 96},
//                {78, 83, 93, 87, 88},
//        };
//
//        System.out.println(array.length);
//        System.out.println(array[2].length);

        int[] array = {1, 5, 3, 8, 2};
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.println(max);
    }
}
