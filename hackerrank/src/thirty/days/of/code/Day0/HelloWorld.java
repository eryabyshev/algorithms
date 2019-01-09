/**
 * @link https://www.hackerrank.com/challenges/30-hello-world/problem
 */
package thirty.days.of.code.Day0;

import java.util.Scanner;

public class HelloWorld {
    private static String HELLO_WORLD = "Hello, World.";
    private static String NEXT_LINE = "\n";
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String input = in.nextLine();
        System.out.println(HELLO_WORLD + NEXT_LINE + input);
    }
}
