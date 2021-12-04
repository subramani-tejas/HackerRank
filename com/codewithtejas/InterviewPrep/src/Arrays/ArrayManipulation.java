/*
 * https://www.hackerrank.com/challenges/crush/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 * */

package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ArrayManipulation {

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        int[] table = new int[n + 1];
        Arrays.fill(table, 0);

        for (List<Integer> row : queries) {
            int a = row.get(0);
            int b = row.get(1);
            int k = row.get(2);

            table[a - 1] += k;
            table[b] -= k;
            System.out.println(Arrays.toString(table));
        }
        long sum = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            sum += table[i];
            max = Math.max(max, sum);
        }
        //System.out.println(Arrays.toString(table));
        return max;
    }

    // O(n*m)
    public static long bruteArrayManipulation(int n, List<List<Integer>> queries) {
        long[] temp = new long[n];
        for (List<Integer> row : queries) {
            int a = row.get(0);
            int b = row.get(1);
            int k = row.get(2);

            for (int i = a - 1; i <= b - 1; i++)
                temp[i] += k;
        }
        return findMax(temp);
    }

    private static long findMax(long[] temp) {
        long max = Integer.MIN_VALUE;
        for (long element : temp)
            if (element > max) max = element;
        return max;
    }

    /*
    * input:
5 3
1 2 100
2 5 100
3 4 100

10 3
1 5 3
4 8 7
6 9 1
    *
    * output: 200
    * output: 10
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);
        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = arrayManipulation(n, queries);
        System.out.println(result);

        bufferedReader.close();
    }
}
