package src.interview.preparation.warm.up.challenges;

import java.util.Scanner;

public class CountingValleys {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        in.nextLine();
        char[] steps = in.nextLine().toCharArray();
        int seeLevel = 0;
        int valleys = 0;

        for (char step : steps) {
            if (step == 'U') {
                seeLevel++;
            } else {
                seeLevel--;
            }
            if (seeLevel == 0 && step == 'U')
                valleys++;
        }
        System.out.println(valleys);
    }
}
