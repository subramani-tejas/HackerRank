/*
  https://www.hackerrank.com/challenges/30-sorting/problem
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Day20_Sorting {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        // Write your code here
        int[] arr = new int[a.size()];
        for (int i = 0; i < arr.length; i++)
            arr[i] = a.get(i);

        Engine engine = new Engine();
        engine.sort(arr);
        System.out.println("Array is sorted in " + Engine.numberOfSwaps + " swaps.");
        System.out.println("First Element: " + arr[0]);
        System.out.println("Last Element: " + arr[arr.length - 1]);

        bufferedReader.close();
    }

    private static class Engine {
        static int numberOfSwaps = 0;

        public void sort(int[] arr) {
            for (int i = 0; i < arr.length; i++) {

                // 3 2 1
                for (int j = 0; j < arr.length - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr, j, j + 1);
                    }
                }

                if (numberOfSwaps == 0) {
                    break;
                }
            }
        }

        private void swap(int[] arr, int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            numberOfSwaps++;
        }
    }
}
