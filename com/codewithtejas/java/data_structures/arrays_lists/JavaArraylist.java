/*
 * https://www.hackerrank.com/challenges/java-arraylist/
 * */

package arrays_lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaArraylist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<List<Integer>> inputList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < d; j++)
                list.add(scanner.nextInt());
            inputList.add(list);
        }

        int q = scanner.nextInt();
        List<List<Integer>> queriesList = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            List<Integer> queries = new ArrayList<>();
            for (int j = 0; j < 2; j++)
                queries.add(scanner.nextInt());
            queriesList.add(queries);
        }
        getAnswers(inputList, queriesList);
    }

    public static void getAnswers(List<List<Integer>> inputList, List<List<Integer>> queriesList) {
        for (List<Integer> query : queriesList) {
            int x = query.get(0);
            int y = query.get(1);

            List<Integer> lineX = inputList.get(x - 1);
            try {
                System.out.println(lineX.get(y - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        }
    }
}
