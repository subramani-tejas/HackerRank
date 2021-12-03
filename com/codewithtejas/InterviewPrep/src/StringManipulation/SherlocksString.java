package StringManipulation;

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

public class SherlocksString {
    static class Result {

        /*
         * Complete the 'isValid' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts STRING s as parameter.
         */

        public static String isValid(String s) {
            // Write your code here
            int minDeletions = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1))
                    minDeletions++;
                if (minDeletions > 1) return "NO";
            }
            return "YES";
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String result = Result.isValid(s);
        System.out.println(result);
        bufferedReader.close();
    }
}
