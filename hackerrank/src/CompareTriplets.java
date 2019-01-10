package src;
/**
 * @linl https://www.hackerrank.com/challenges/compare-the-triplets/problem
 */

import java.util.Scanner;

public class CompareTriplets {
    private static Scanner in = new Scanner(System.in);
    private static int COUNT = 3;

    private static int[] readInput() {
        int[] array = new int[COUNT];
        for(int i = 0; i < array.length; i++)
            array[i] = in.nextInt();
        return array;
    }

    private static void getScore(int[] a, int[] b) {
        int scoreA = 0;
        int scoreB = 0;

        for(int i = 0; i < COUNT; i++) {
            if(a[i] > b[i])
                scoreA++;
            else if(a[i] < b[i])
                scoreB++;
        }
        System.out.println(scoreA + " " + scoreB);
    }

    public static void main(String[] args) {
        int[] a = readInput();
        int[] b = readInput();
        getScore(a, b);
    }
}
