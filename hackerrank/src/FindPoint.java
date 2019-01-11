/**
 * @link https://www.hackerrank.com/challenges/find-point/problem
 */
package src;

import java.io.IOException;
import java.util.Scanner;

public class FindPoint {

    static int[] findPoint(int px, int py, int qx, int qy) {
        int ry = qy + (qy - py);
        int rx = qx + (qx - px);
        return new int[] { rx, ry };

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(scanner.nextLine().trim());
        for (int nItr = 0; nItr < n; nItr++) {
            String[] pxPyQxQy = scanner.nextLine().split(" ");
            int px = Integer.parseInt(pxPyQxQy[0].trim());
            int py = Integer.parseInt(pxPyQxQy[1].trim());
            int qx = Integer.parseInt(pxPyQxQy[2].trim());
            int qy = Integer.parseInt(pxPyQxQy[3].trim());
            int[] result = findPoint(px, py, qx, qy);
            System.out.println(result[0] + " " + result[1]);
        }
    }
}
