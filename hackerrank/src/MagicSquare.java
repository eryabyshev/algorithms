package src;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSquare {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        int[] square = new int[9];
        int sum = 0;

        for(int i = 0; i < square.length; i++)
            square[i] = in.nextInt();
        Arrays.sort(square);

        for(int i = 0; i < square.length;i++)
            sum += Math.max(i + 1, square[i]) - Math.min(i + 1, square[i]);

        System.out.println(sum);
    }

}
