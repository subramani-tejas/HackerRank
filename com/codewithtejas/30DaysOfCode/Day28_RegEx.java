/*
  https://www.hackerrank.com/challenges/30-regex-patterns/problem
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

public class Day28_RegEx {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        String emailRegEx = ".+@gmail\\.com$";
        Pattern pattern = Pattern.compile(emailRegEx);

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String name = in.next();
            String email = in.next();
            Matcher matcher = pattern.matcher(email);

            if (matcher.find()) list.add(name);
        }
        Collections.sort(list);
        list.forEach(System.out::println);
    }
}
