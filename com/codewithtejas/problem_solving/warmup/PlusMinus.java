/*
  https://www.hackerrank.com/challenges/plus-minus/problem
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.plusMinus(arr);

        bufferedReader.close();
    }

    static class Result {

        /*
         * Complete the 'plusMinus' function below.
         *
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static void plusMinus(List<Integer> arr) {
            // Write your code here
            double negativeCount = 0;
            double positiveCount = 0;
            double zeroCount = 0;
            double n = arr.size();

            for (int i = 0; i < n; i++) {
                if (arr.get(i) > 0) positiveCount++;
                else if (arr.get(i) < 0) negativeCount++;
                else zeroCount++;
            }

            System.out.printf("%.6f \n", positiveCount / n);
            System.out.printf("%.6f \n", negativeCount / n);
            System.out.printf("%.6f \n", zeroCount / n);
        }

    }
}
