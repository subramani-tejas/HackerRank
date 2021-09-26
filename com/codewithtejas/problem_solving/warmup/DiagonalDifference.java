/*
  https://www.hackerrank.com/challenges/diagonal-difference/problem
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {

        // convert to 2D array
        int[][] myArray = new int[arr.size()][];
        for (int i = 0; i < arr.size(); i++) {
            myArray[i] = new int[arr.get(i).size()];
            for (int j = 0; j < myArray[i].length; j++) {
                myArray[i][j] = arr.get(i).get(j);
            }
        }

        // get principal diagonal elements
        int[] primary = getPrimaryDiagonal(myArray, arr.size());

        // sum of primary
        int primarySum = 0;
        for (int i = 0; i < primary.length; i++)
            primarySum += primary[i];

        // get secondary diagonal elements
        int[] secondary = getSecondaryDiagonal(myArray, arr.size());

        // sum of secondary
        int secondarySum = 0;
        for (int i = 0; i < secondary.length; i++)
            secondarySum += secondary[i];

        return Math.abs(primarySum - secondarySum);
    }

    private static int[] getPrimaryDiagonal(int[][] matrix, int n) {
        int[] priDiag = new int[n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i == j)
                    priDiag[i] = matrix[i][j];

        return priDiag;
    }

    private static int[] getSecondaryDiagonal(int[][] matrix, int n) {
        int[] secDiag = new int[n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if ((i + j) == (n - 1))
                    secDiag[i] = matrix[i][j];

        return secDiag;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
