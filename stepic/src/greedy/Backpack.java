/**
 * @link https://stepik.org/lesson/13238/step/10?unit=3424
 */
package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Backpack {

    private static class CostWeight {
        double cost;
        double weight;

        public CostWeight(double cost, double weight) {
            this.cost = cost;
            this.weight = weight;
        }
    }


    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        int item_counter = in.nextInt();
        int bag_weight = in.nextInt();

        List<CostWeight> list = new ArrayList<>();
        for (int i = 0; i < item_counter; i++) {
            list.add(new CostWeight(in.nextDouble(), in.nextDouble()));
        }
        Collections.sort(list, (a, b) -> Double.compare(b.cost / b.weight, a.cost / a.weight));

        double cost = 0.0;

        for(int i = 0; i < item_counter && bag_weight > 0; i++){
            CostWeight item = list.get(i);

            if(bag_weight > item.weight){
                cost += item.cost;
                bag_weight -= item.weight;
            }
            else{
                cost += (item.cost / item.weight) * bag_weight;
                bag_weight = 0;
            }
        }

        String result = String.format("%.3f", cost);
        System.out.println(result);
    }

}
