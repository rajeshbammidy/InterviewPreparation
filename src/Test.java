import java.io.*;
import java.util.*;


public class Test {
    public int maxp3(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < 3; i++) {
            minHeap.add(arr[i]);
            maxHeap.add(arr[i]);
        }
        for (int i = 3; i < arr.length; i++) {

            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
            if (arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }

        }
        int ans = 1;
        if (minHeap.peek() >= 0) {
            return minHeap.poll() * minHeap.poll() * minHeap.poll();
        } else if (minHeap.peek() < 0) {
            return maxHeap.peek() * maxHeap.peek() * minHeap.peek();
        }
        return -1;

    }



    public static void main(String[] args) throws Exception {

    }
}