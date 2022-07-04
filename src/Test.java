import java.io.*;
import java.util.*;

class No {
    int x;
    int y;

    No(int x, int y) {
        this.y = y;
        this.x = x;
    }
}

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
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> {
            return b[1] - a[1];
        });
        System.out.println(Arrays.deepToString(boxTypes));
        int boxCount = 0,  maxUnits = 0;

        for (int i = 0; i < boxTypes.length; i++) {
            int boxes = boxTypes[i][0];
            int units = boxTypes[i][1];
            if (boxCount + boxes <= truckSize) {
                boxCount += boxes;
                maxUnits += boxes * units;
            } else {
                int r = truckSize - boxCount;
                boxCount += r;
                maxUnits += (r * units);
            }
            if (boxCount == truckSize) return maxUnits;
        }
        return maxUnits;

    }

    public static void main(String[] args) throws Exception {
       int arr[]= Arrays.copyOf(new int[]{1,2,3},4);
        System.out.println(Arrays.toString(arr));
    }
}