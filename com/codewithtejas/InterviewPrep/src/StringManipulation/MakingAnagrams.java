package StringManipulation;
/*
  https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MakingAnagrams {
    static class Result {

        public static int makeAnagram(String a, String b) {
            /*
             * Complete the 'makeAnagram' function below.
             *
             * The function is expected to return an INTEGER.
             * The function accepts following parameters:
             *  1. STRING a
             *  2. STRING b
             */
            final int ALPHABETS = 26;
            int minDeletions = 0;
            int[] aFreq = new int[ALPHABETS];
            int[] bFreq = new int[ALPHABETS];

            // O(n)
            for (var item : a.toCharArray())
                aFreq[item - 'a'] += 1;

            // O(n)
            for (var item : b.toCharArray())
                bFreq[item - 'a'] += 1;

            for (int i = 0; i < ALPHABETS; i++)
                minDeletions += Math.abs(aFreq[i] - bFreq[i]);

            return minDeletions;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String a = bufferedReader.readLine();
        String b = bufferedReader.readLine();

        int res = Result.makeAnagram(a, b);
        System.out.println(res);

        bufferedReader.close();
    }
}
