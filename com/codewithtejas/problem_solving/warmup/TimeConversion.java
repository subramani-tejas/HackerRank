/*
  https://www.hackerrank.com/challenges/time-conversion/problem
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

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    static class Result {

        /*
         * Complete the 'timeConversion' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts STRING s as parameter.
         */

        public static String timeConversion(String s) {
            // Write your code here
            final int TWELVE = 12;
            final int ZERO = 0;
            String output = "";
            String[] input = s.split(":");

            int hour = Integer.parseInt(input[0]);
            String min = input[1];
            String second = input[2].substring(0, input[2].length() - 2);
            String meridian = input[2].substring(input[2].length() - 2);

            if ((hour >= ZERO && hour < TWELVE))
                if (meridian.equals("AM"))
                    output = String.format("%02d", hour) + ":" + min + ":" + second;
                else output = (hour + TWELVE) + ":" + min + ":" + second;

            else if (hour == TWELVE)
                if (meridian.equals("AM"))
                    output = "00" + ":" + min + ":" + second;
                else output = hour + ":" + min + ":" + second;

            return output;
        }

    }
}
