package fib; /**
 * @link https://stepik.org/lesson/13228/step/7?unit=3414
 */

import java.util.Scanner;

public class LastNumberOfFib {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int first = 0;
        int second = 1;

        for(int i = 1; i < n; i++){
            int temp = (second + first) % 10;
            first = second;
            second = temp;
        }
        System.out.println(second);
    }
}
