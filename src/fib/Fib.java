package fib; /**
 * @link https://stepik.org/lesson/13228/step/6?unit=3414
 */

import java.util.Scanner;

public class Fib {
    public static void main(String[] args) {

        System.out.println((13 + 21) % 10);

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if(n == 0 || n == 1)
            System.out.println(1);
        else{
            int first = 1;
            int second = 1;
            int result = 1;
            for(int i = 2; i < n; i++){
                result = first + second;
                first = second;
                second = result;
            }
            System.out.println(result);
        }
    }
}
