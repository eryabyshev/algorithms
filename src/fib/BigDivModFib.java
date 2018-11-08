package fib; /**
@link https://stepik.org/lesson/13228/step/8?unit=3414
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BigDivModFib {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        long n = in.nextLong();
        long m = in.nextLong();

        List<Long> fib = new ArrayList<>();
        long first = 0;
        long second = 1;

        fib.add(first);
        fib.add(second);

        for (long i = 1; i < n; i++) {
            long temp = second;
            second = (second + first) % m;
            first = temp;

            if (first == 0 && second == 1) {
                fib.remove(fib.size() - 1);
                break;
            } else
                fib.add(second);

        }
        long temp = n % fib.size();

        System.out.println(fib.get((int) temp));
    }

}
