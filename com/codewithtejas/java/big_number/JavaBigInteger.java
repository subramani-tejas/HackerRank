// https://www.hackerrank.com/challenges/java-biginteger/problem

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        var a = scanner.nextBigInteger();
        var b = scanner.nextBigInteger();
        scanner.close();

        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
    }
}
