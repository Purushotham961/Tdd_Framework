package purushotham.practice.arrays;

public class MaxAndMin {
    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 5, 4, 2, 5, 6, 9, 5, 4, 7, 5};

        int min = arr[0], max = arr[0];

        for (int num : arr) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        System.out.println("min : " + min);
        System.out.println("max : " + max);


    }
}
