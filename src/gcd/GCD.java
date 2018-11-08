/**
 * @link https://stepik.org/lesson/13229/step/5?unit=3415
 */

package gcd;

import java.util.Scanner;

public class GCD {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        long a = in.nextLong();
        long b = in.nextLong();

        System.out.println(getGCD(a, b));

    }


    private static long getGCD(long a, long b){
        if(a == 0)
            return b;
        else if(b == 0)
            return a;

        else if(a > b)
            return getGCD(a % b, b);
        else
            return getGCD(b % a, a);

    }

}
