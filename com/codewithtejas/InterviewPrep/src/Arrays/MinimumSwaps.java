/*
* https://www.hackerrank.com/challenges/minimum-swaps-2?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
* */

package Arrays;

import java.io.IOException;
import java.util.Scanner;

public class MinimumSwaps {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);
        System.out.println(res);
        scanner.close();
    }

    private static int minimumSwaps(int[] arr) {
        int count = 0;
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != arr[arr[i] - 1]) {
                swap(arr, i, arr[i] - 1);
                count++;
            }
            else  i++;
        }
        return count;
    }

    private static int swaps(int[] arr) {
        int swapCount = 0;
        boolean isSorted = false;
        for (int i = 0; i < arr.length; i++) {
            isSorted = true;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    isSorted = false;
                    swapCount++;
                }
            }
            if (isSorted) return swapCount;
        }
        return swapCount;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
