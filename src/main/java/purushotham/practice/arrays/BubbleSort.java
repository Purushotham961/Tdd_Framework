package purushotham.practice.arrays;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 8, 7, 5, 4, 5, 2, 9, 5, 5, 98, 1};
        bubbleSorting(arr);

        System.out.println(Arrays.toString(arr));

    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void bubbleSorting(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { //-1 is used to avoid iteration on last element, since the array will be already sorted and no need of further iteration for last element
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
