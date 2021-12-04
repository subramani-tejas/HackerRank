/*
*   https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
* */

package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class NewYearChaos {

    /*
    * input:
    *   1
        4
        1 4 2 3
    * */
    public static void minimumBribes(List<Integer> q) {
        int count = 0;
        for (int i = q.size() - 1; i >= 0; i--) {
            if (q.get(i) != i + 1) {
                if (q.get(i - 1) == i + 1) {
                    count += 1;
                    swap(q, i - 1, i);
                    System.out.println("1 bribe: swapped ---> " + q);
                } else if (q.get(i - 2) == i + 1) {
                    count += 2;
                    swap(q, i - 2, i - 1);
                    System.out.println("2 bribes: swapped ---> " + q);
                    swap(q, i - 1, i);
                    System.out.println("2 bribes: swapped ---> " + q);
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(count);
    }

    private static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
