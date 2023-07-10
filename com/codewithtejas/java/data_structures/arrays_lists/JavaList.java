/*
* https://www.hackerrank.com/challenges/java-list/
* */

package arrays_lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class JavaList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(scanner.nextInt());

        int q = scanner.nextInt();
        for (int i = 1; i <= q; i++) {
            String op = scanner.next();
            if (Objects.equals(op, "Insert")) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                list.add(x, y);
            } else if (Objects.equals(op, "Delete")) {
                int z = scanner.nextInt();
                list.remove(z);
            }
        }
        for (Integer element : list)
            System.out.print(element + " ");
    }
}
