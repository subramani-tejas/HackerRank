/*
* https://www.hackerrank.com/challenges/java-negative-subarray/problem
* */

package arrays_lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaSubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(scanner.nextInt());

        int result = findNegativeSubArrays(list);
        System.out.println(result);
    }

    public static int findNegativeSubArrays(List<Integer> list) {
        getAllSubArrays(list);
        return countNegativeSums(subArraySum());
    }

    private static final List<List<Integer>> subList = new ArrayList<>();

    private static void getAllSubArrays(List<Integer> list) {
        for (int i = 0; i < list.size(); i++)
            for (int j = i; j < list.size(); j++)
                getAllSubArrays(list, i, j);
    }

    private static void getAllSubArrays(List<Integer> list, int start, int end) {
        List<Integer> temp = new ArrayList<>();
        for (int i = start; i <= end; i++)
            temp.add(list.get(i));
        subList.add(temp);
    }

    private static List<Integer> subArraySum() {
        List<Integer> sumList = new ArrayList<>();
        for (List<Integer> temp : subList) {
            int sum = 0;
            for (Integer integer : temp) sum += integer;
            sumList.add(sum);
        }
        return sumList;
    }

    private static int countNegativeSums(List<Integer> sumList) {
        int count = 0;
        for (Integer item : sumList)
            if (item < 0) count++;
        return count;
    }
}
