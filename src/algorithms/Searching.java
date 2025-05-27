package algorithms;

import static algorithms.Sorting.*;

public class Searching {

    public static int linearSearch(int[] arr, int x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                return mid;
            }

            if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {7, 2, 11, 4, 56, 23, 9, 45, 10, 17};

//        selectionSort(arr);
//        bubbleSort(arr);
        insertionSort(arr);

        print(arr);

        int x = 10;
        int result = binarySearch(arr, x);
        if (result == -1) {
            System.out.println("O elemento não está presente no vetor");
        } else {
            System.out.println("O elemento está presente no índice " + result);
        }
    }
}
