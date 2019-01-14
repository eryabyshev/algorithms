package src.interview.preparation.warm.up.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SockMerchant {
    private static Scanner in = new Scanner(System.in);

    private static int getResult(Map<Integer, Integer> map) {
        int result = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int temp = entry.getValue();
            if(entry.getValue() % 2 != 0)
                temp -= 1;
            result += temp / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        int size = in.nextInt();
        Map<Integer, Integer> store = new HashMap<Integer, Integer>();

        for(int i = 0; i < size; i++) {
             int input = in.nextInt();
             Integer temp = store.get(input);
             if(temp != null) {
                 temp++;
                 store.put(input, temp);
             }
             else {
                 store.put(input, 1);
             }
        }
        System.out.println(getResult(store));

    }
}
