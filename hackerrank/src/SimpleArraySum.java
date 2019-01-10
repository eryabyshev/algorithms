/**
 * @link https://www.hackerrank.com/challenges/simple-array-sum/problem
 */
package src;

import java.util.Scanner;

public class SimpleArraySum {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int count = in.nextInt();
        int sum = 0;
        for (int i = 0; i < count; i++)
            sum += in.nextInt();
        System.out.println(sum);
    }
}