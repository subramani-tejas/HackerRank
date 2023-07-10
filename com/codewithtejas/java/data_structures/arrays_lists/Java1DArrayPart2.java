/*
 * https://www.hackerrank.com/challenges/java-1d-array/problem
 * */

package arrays_lists;

import java.util.Scanner;

public class Java1DArrayPart2 {
    public static boolean canWin(int leap, int[] game) {
        return canWin(leap, game, 0);
    }
    private static boolean canWin(int leap, int[] game, int index) {
        if (index >= game.length) {
            System.out.println("win!");
            return true;
        }
        if (index < 0 || game[index] != 0) return false;
        game[index] = 1;
        System.out.println("move: " + index);
        return canWin(leap, game, index + leap) ||
                canWin(leap, game, index + 1) ||
                canWin(leap, game, index - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}
