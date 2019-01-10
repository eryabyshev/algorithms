package src;

/**
 * @linl https://www.hackerrank.com/challenges/a-very-big-sum/problem
 */

import java.util.Scanner;

public class VeryBigSum {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int count = in.nextInt();
        long sum = 0;
        for (int i = 0; i < count; i++)
            sum += in.nextLong();
        System.out.println(sum);
    }

}
