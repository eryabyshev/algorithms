/**
 * @link https://stepik.org/lesson/13238/step/9?unit=3424
 */
package greedy;

import java.util.*;

public class Dots {

    private static class Section{
        int left;
        int right;

        public Section(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }


    private static Scanner in = new Scanner(System.in);


    private static int getNextNotCrossSelection(int from, List<Section> list){

        int minPoint = list.get(from).right;

        for(int i = from + 1; i < list.size(); i++){
            if(list.get(i).left >= minPoint)
                return i;
        }
        return -1;


    }

    public static void main(String[] args) {
        int count = in.nextInt();
        List<Section>sections = new ArrayList<>();
        for(int i = 0; i < count; i++)
            sections.add(new Section(in.nextInt(), in.nextInt()));

        Collections.sort(sections, (a, b) -> Integer.compare(a.right, b.right));
        Set<Integer>dots = new TreeSet<>();

        //do reliable step
        dots.add(sections.get(0).right);

        for(int i = 0; i < sections.size(); i++){
            int nextSelection = getNextNotCrossSelection(i, sections);
            if(nextSelection != -1){
                dots.add(sections.get(nextSelection).left);
                i = nextSelection;
            }

        }

        System.out.println(dots.size());
        dots.forEach(e -> System.out.print(e + " "));


    }



}
