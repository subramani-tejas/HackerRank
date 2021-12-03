/*
 * https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 * */

package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
*   1 1 1 0 0 0
    0 1 0 0 0 0
    1 1 1 0 0 0
    0 0 2 4 4 0
    0 0 0 2 0 0
    0 0 1 2 4 0
*
* */
public class Array2D {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();
        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        int result = hourglassSum(arr);
        System.out.println(result);
        bufferedReader.close();
    }

    private static int hourglassSum(List<List<Integer>> arr) {
        int totalHourglassSum = Integer.MIN_VALUE;
        int rows = arr.size();
        int columns = arr.get(0).size();
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < columns - 2; j++) {
                int hourglassSum = arr.get(i).get(j) +
                        arr.get(i).get(j + 1) +
                        arr.get(i).get(j + 2) +
                        arr.get(i + 1).get(j + 1) +
                        arr.get(i + 2).get(j) +
                        arr.get(i + 2).get(j + 1) +
                        arr.get(i + 2).get(j + 2);
                totalHourglassSum = Math.max(totalHourglassSum, hourglassSum);
            }
        }
        return totalHourglassSum;
    }
}
