/**
 * @link https://stepik.org/lesson/13238/step/9?unit=3424
 */
package greedy;

import java.util.*;

public class Dots {

    private static class Section{
        int left;
        int right;

        public Section(int left , int right) {
            this.left = left;
            this.right = right;
        }
    }


    private static Scanner in = new Scanner(System.in);


    private static List<Integer> cross(List<Section> sections){
        List<Integer> dots = new ArrayList<>();

        for(int i = 0; i < sections.size(); i++){
            int point = sections.get(i).right;
            for(int j = i; j < sections.size() && point <= sections.get(j).right && point >= sections.get(j).left; j++){
                i = j;
            }
            dots.add(point);
        }
        return dots;
    }


    public static void main(String[] args) {
        int count = in.nextInt();
        List<Section>sections = new ArrayList<>();
        for(int i = 0; i < count; i++)
            sections.add(new Section(in.nextInt(), in.nextInt()));

        Collections.sort(sections, (a, b) -> Long.compare(a.right, b.right));
        List<Integer>dots = cross(sections);
        System.out.println(dots.size());
        dots.forEach(e-> System.out.print(e + " "));
    }
}
