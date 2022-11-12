package LeetCode.Nov22.leetcode.editor.en;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * The median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value, and the median is the mean of the two
 * middle values.
 * <p>
 * <p>
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * <p>
 * <p>
 * Implement the MedianFinder class:
 * <p>
 * <p>
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data
 * structure.
 * double findMedian() returns the median of all elements so far. Answers within 1
 * 0⁻⁵ of the actual answer will be accepted.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * Output
 * [null, null, null, 1.5, null, 2.0]
 * <p>
 * Explanation
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * -10⁵ <= num <= 10⁵
 * There will be at least one element in the data structure before calling
 * findMedian.
 * At most 5 * 10⁴ calls will be made to addNum and findMedian.
 * <p>
 * <p>
 * <p>
 * Follow up:
 * <p>
 * <p>
 * If all integer numbers from the stream are in the range [0, 100], how would
 * you optimize your solution?
 * If 99% of all integer numbers from the stream are in the range [0, 100], how
 * would you optimize your solution?
 * <p>
 * <p>
 * Related Topics Two Pointers Design Sorting Heap (Priority Queue) Data Stream 👍
 * 9228 👎 176
 */

//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder295 {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder295() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }
        if (num <= maxHeap.peek())
            maxHeap.add(num);
        else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        if (maxHeap.size() - minHeap.size() >= 2) {
            minHeap.add(maxHeap.poll());
        }

    }

    public double findMedian() {
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();

        if (((maxHeapSize + minHeapSize) & 1) == 0) {
            return (maxHeap.peek() + (double) minHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 * <p>
 * 1 2 3
 * 4 5
 */
//leetcode submit region end(Prohibit modification and deletion)
