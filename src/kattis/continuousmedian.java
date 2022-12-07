package kattis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class continuousmedian {
    static PriorityQueue<Integer> minHeap;
    static PriorityQueue<Integer> maxHeap;

    public static void addNum(int num) {
        /**
         * If the maxHeap is empty add the elements into maxHeap
         */
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }
        /**
         * If the element less than maxHeap peek add the element into the maxHeap else add into minHeap
         */
        if (num <= maxHeap.peek())
            maxHeap.add(num);
        else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        /**
         * At any given point of time if the minHeap size is greater than maxHeap.size() - minHeap.size() >= 2 pop the maxHeap element and add into minHeap
         *
         */
        if (maxHeap.size() - minHeap.size() >= 2) {
            minHeap.add(maxHeap.poll());
        }

    }

    public static double findMedian() {
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();

        if (((maxHeapSize + minHeapSize) & 1) == 0) {
            return (maxHeap.peek() + (double) minHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(bf.readLine());
            String str[] = bf.readLine().split("\\s");
            long sum = 0;
            /**
             * Initialize the min heap
             */
            minHeap = new PriorityQueue<>();
            /**
             * Initialize the max heap
             */
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            for (String x : str) {
                addNum(Integer.parseInt(x));
                sum += Math.floor(findMedian());
            }
            System.out.println(sum);

        }

    }
}
