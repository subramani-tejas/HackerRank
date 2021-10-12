/*
 *  https://www.hackerrank.com/challenges/java-anagrams/problem
*/

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);
        String a = scanner.next().toLowerCase();
        String b = scanner.next().toLowerCase();
        scanner.close();
        var result = new Anagram();
        System.out.println(result.isAnagram(a, b) ? "Anagrams" : "Not Anagrams");
    }
}

class Anagram {
    public boolean isAnagram(String a, String b) {
        return mapFrequency(a).equals(mapFrequency(b));
    }

    private Map<Character, Integer> mapFrequency(String input) {

        Map<Character, Integer> myMap = new HashMap<Character, Integer>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
//            if (myMap.get(c) == null)
//                myMap.put(c, 1);
//            else myMap.put(c, myMap.get(c) + 1);

            myMap.merge(c, 1, (prev, one) -> prev + 1);
        }
        return myMap;
    }
}
