package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Backpack {

    private static class CostWeight {
        int cost;
        int weight;

        public CostWeight(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }
    }

    public static double round(double value, int places) {
        if (places < 0)
            throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        int counter = in.nextInt();
        int weight = in.nextInt();

        List<CostWeight> list = new ArrayList<>();
        for (int i = 0; i < counter; i++) {
            list.add(new CostWeight(in.nextInt(), in.nextInt()));
        }
        Collections.sort(list, (a, b) -> Double.compare(a.cost / a.weight, b.cost / b.weight));

        double cost = 0.0;
        int i = 0;
        while (weight > 0) {

            CostWeight cw = list.get(i);
            if (weight < list.get(i).weight) {
                cost = +(double) weight * (double) cw.cost / (double) cw.weight;
                weight = 0;
            } else {
                cost += (double) cw.cost;
                weight -= cw.weight;
            }
        }
        String result = String.format("%.3f", cost);
        System.out.println(result);
    }

}
