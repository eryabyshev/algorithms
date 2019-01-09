package thirty.days.of.code.Day1;

import java.util.Scanner;

public class DataTypes {
    private static String s = "HackerRank ";
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int line1 = scan.nextInt();
        double line2 = scan.nextDouble();
        String line3 = "";
        while (scan.hasNext())
            line3 += scan.nextLine() + " ";
        double temp = line1 + line2;

        System.out.println((int)temp);
        System.out.println(String.format("%.1f", line2 * 2));
        System.out.println(s + line3);
    }
}
