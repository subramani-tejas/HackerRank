/*
  https://www.hackerrank.com/challenges/30-running-time-and-complexity/problem
*/

import java.io.*;
import java.util.*;

public class Day25_Complexity {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        // # test cases
        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();

            if (isPrime(n))
                System.out.println("Prime");
            else System.out.println("Not prime");
        }
    }

    public static boolean isPrime(int n) {
        if (n == 1)
            return false;

        // O((n)^1/2)
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;

        // O(n)   
        // for(int i = 2; i < n; i++){
        //     if(n % i == 0)
        //         return false;
        // }

        return true;
    }
}
