package ScalerAcademySolutions.heaps1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.heaps1
 * Date:Aug, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 */
public class MinimumLargestElement {
    static class Pair {
        public Pair(int curValue, int orgValue) {
            this.curValue = curValue;
            this.orgValue = orgValue;
        }

        @Override
        public String toString() {
            return this.curValue + " " + this.orgValue;
        }

        int curValue, orgValue;
    }

    public int solve(ArrayList<Integer> list, int B) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return new Integer(o1.curValue + o1.orgValue).compareTo(o2.orgValue + o2.curValue);
            }
        });
        int max = list.stream().max(Integer::compare).get();
        list.stream().forEach(x -> minHeap.add(new Pair(x, x)));
        while (B-- > 0 && !minHeap.isEmpty()) {
            Pair p = minHeap.poll();
            max = Math.max(p.orgValue + p.curValue, max);
            minHeap.add(new Pair(p.orgValue + p.curValue, p.orgValue));
        }
        return max;
    }

    public static void main(String[] args) {
        new MinimumLargestElement().solve(new ArrayList<>(Arrays.asList(5, 1, 4, 2)), 5);
    }
}
