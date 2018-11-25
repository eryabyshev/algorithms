/**
 https://www.hackerrank.com/challenges/a-chocolate-fiesta/problem
 8/13 test cases failed :(
 */
import java.io.*;
import java.util.*;


public class ChocolateFiesta {

    /**
     Чётное ± Чётное = Чётное
     Чётное ± Нечётное = Нечётное
     Нечётное ± Нечётное = Чётное

    Количество подмножеств конечного множества 2^n
    Количество для четных 2^even
    Количество для нечетных 2^odd - 1, -1 так как {A1}, для odd не являентся четным

    * ??? 1000000007
     * */

    static int solve(int even, int odd) {
        return (int) (Math.pow(2, even)) * (int)Math.pow(2, odd - 1) - 1 ;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int count = scanner.nextInt();
        int odd = 0;
        int even = 0;

        for(int i = 0; i < count; i++) {
            if (scanner.nextInt() % 2 == 0)
                even++;
            else
                odd++;
        }

        System.out.println(solve(even, odd));
    }
}
