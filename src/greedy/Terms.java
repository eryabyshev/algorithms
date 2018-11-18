/**
 * @link https://stepik.org/lesson/13238/step/11?unit=3424
 */
package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Terms {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();


        List<Integer> result = new ArrayList<>();
        for(int i = 1; ;i++){

            if(i * 2 < n) {
                result.add(i);
                n -= i;
            }
            else{
                result.add(n);
                break;
            }

        }
        System.out.println(result.size());
        result.forEach(e-> System.out.print(e + " "));

    }

}
