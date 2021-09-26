/*
  https://www.hackerrank.com/challenges/counting-valleys/problem
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int counter = 0;
        int valley = 0;
        Character c1 = new Character('U');
        Character c2 = new Character('D');

        for (int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(c1.equals(c))
                counter++;
            else if(c2.equals(c)){
                counter--;
                if(counter==-1)
                    valley++;
            }
        }
        return valley;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
