/*
  https://www.hackerrank.com/challenges/30-nested-logic/problem
*/

import java.io.*;
import java.util.*;

public class Day26_NestedLogic {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);

        // date returned
        int dayReturned = scanner.nextInt();
        int monthReturned = scanner.nextInt();
        int yearReturned = scanner.nextInt();

        // date due
        int dayDue = scanner.nextInt();
        int monthDue = scanner.nextInt();
        int yearDue = scanner.nextInt();

        scanner.close();
        int fine = 0;

        if (yearReturned < yearDue) {
        } else {
            if (yearReturned > yearDue) fine = 10000;
            else if (monthReturned > monthDue)
                fine = 500 * (monthReturned - monthDue);
            else if (dayReturned > dayDue)
                fine = 15 * (dayReturned - dayDue);
        }

        System.out.println(fine);
    }
}
