/*
*  https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
* */

package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LeftRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        // List<Integer> result = rotateLeft(a, d);
        List<Integer> result = optimizedRotateLeft(a, d);
        System.out.println(result);
        bufferedReader.close();
    }

    // O(d * n)
    private static List<Integer> rotateLeft(List<Integer> a, int numberOfRotations) {
        for (int i = 0; i < numberOfRotations; i++)     // O(d * n)
            rotateLeftByOne(a, numberOfRotations);      // O(n)
        return a;
    }

    private static void rotateLeftByOne(List<Integer> a, int numberOfRotations) {
        int temp = a.get(0);
        int size = a.size();
        for (int i = 0; i < size - 1; i++)
            a.set(i, a.get(i + 1));
        a.set(size - 1, temp);
    }

    // O(n)
    private static List<Integer> optimizedRotateLeft(List<Integer> a, int numberOfRotations) {
        reverse(a, 0, numberOfRotations - 1);
        reverse(a, numberOfRotations, a.size() - 1);
        reverse(a, 0, a.size() - 1);
        return a;
    }

    private static void reverse(List<Integer> a, int start, int end) {
        while (start < end) {
            swap(a, start, end);
            start++;
            end--;
        }
    }

    private static void swap(List<Integer> a, int start, int end) {
        int temp = a.get(start);
        a.set(start, a.get(end));
        a.set(end, temp);
    }
}
