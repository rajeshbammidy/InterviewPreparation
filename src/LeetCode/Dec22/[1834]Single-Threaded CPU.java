package LeetCode.Dec22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You are given n tasks labeled from 0 to n - 1 represented by a 2D integer array
 * tasks, where tasks[i] = [enqueueTimei, processingTimei] means that the ith task
 * will be available to process at enqueueTimei and will take processingTimei to
 * finish processing.
 *
 * You have a single-threaded CPU that can process at most one task at a time and
 * will act in the following way:
 *
 *
 * If the CPU is idle and there are no available tasks to process, the CPU
 * remains idle.
 * If the CPU is idle and there are available tasks, the CPU will choose the one
 * with the shortest processing time. If multiple tasks have the same shortest
 * processing time, it will choose the task with the smallest index.
 * Once a task is started, the CPU will process the entire task without stopping.
 *
 * The CPU can finish a task then start a new one instantly.
 *
 *
 * Return the order in which the CPU will process the tasks.
 *
 *
 * Example 1:
 *
 *
 * Input: tasks = [[1,2],[2,4],[3,2],[4,1]]
 * Output: [0,2,3,1]
 * Explanation: The events go as follows:
 * - At time = 1, task 0 is available to process. Available tasks = {0}.
 * - Also at time = 1, the idle CPU starts processing task 0. Available tasks = {}.
 *
 * - At time = 2, task 1 is available to process. Available tasks = {1}.
 * - At time = 3, task 2 is available to process. Available tasks = {1, 2}.
 * - Also at time = 3, the CPU finishes task 0 and starts processing task 2 as it
 * is the shortest. Available tasks = {1}.
 * - At time = 4, task 3 is available to process. Available tasks = {1, 3}.
 * - At time = 5, the CPU finishes task 2 and starts processing task 3 as it is
 * the shortest. Available tasks = {1}.
 * - At time = 6, the CPU finishes task 3 and starts processing task 1. Available
 * tasks = {}.
 * - At time = 10, the CPU finishes task 1 and becomes idle.
 *
 *
 * Example 2:
 *
 *
 * Input: tasks = [[7,10],[7,12],[7,5],[7,4],[7,2]]
 * Output: [4,3,2,0,1]
 * Explanation: The events go as follows:
 * - At time = 7, all the tasks become available. Available tasks = {0,1,2,3,4}.
 * - Also at time = 7, the idle CPU starts processing task 4. Available tasks = {0,
 * 1,2,3}.
 * - At time = 9, the CPU finishes task 4 and starts processing task 3. Available
 * tasks = {0,1,2}.
 * - At time = 13, the CPU finishes task 3 and starts processing task 2. Available
 * tasks = {0,1}.
 * - At time = 18, the CPU finishes task 2 and starts processing task 0. Available
 * tasks = {1}.
 * - At time = 28, the CPU finishes task 0 and starts processing task 1. Available
 * tasks = {}.
 * - At time = 40, the CPU finishes task 1 and becomes idle.
 *
 *
 *
 * Constraints:
 *
 *
 * tasks.length == n
 * 1 <= n <= 10⁵
 * 1 <= enqueueTimei, processingTimei <= 10⁹
 *
 *
 * Related Topics Array TopicWiseSolutions.Strings.Sorting Heap (Priority TopicWiseSolutions.Strings.Queue) 👍 2246 👎 194
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1834 {
    static class Node {
        int enqueueTime;
        int processingTime;
        int index;

        public Node(int enqueueTime, int processingTime, int index) {
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
            this.index = index;
        }
    }

    public int[] getOrder(int[][] tasks) {

        int order[] = new int[tasks.length];
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < tasks.length; i++) {
            list.add(new Node(tasks[i][0], tasks[i][1], i));
        }
        list.sort(((o1, o2) -> {
            if (o1.enqueueTime == o2.enqueueTime) {
                return o1.processingTime - o2.processingTime;
            }
            return o1.enqueueTime - o2.enqueueTime;
        }));
        /**
         * Copy the elements into the queue,for easy access of the start element (not necessary)
         */
        for (Node node : list) queue.add(node);

/**
 * Use the comparator to sort the frames according to least processingTime
 */
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> {
            if (o1.processingTime == o2.processingTime) {
                return o1.index - o2.index;
            }
            return o1.processingTime - o2.processingTime;
        }));
        int endTime = list.get(0).enqueueTime;
        int index = 0;

        /**
         * Add the first frame to the waiting priority TopicWiseSolutions.Strings.Queue
         */
        if (!queue.isEmpty()) {
            pq.add(queue.poll());
        }

        while (!queue.isEmpty() || !pq.isEmpty()) {
            /**
             * If we have elements in the queue to process, pick the most eligible one and process it
             */
            if (!pq.isEmpty()) {
                Node node = pq.poll();
                endTime += node.processingTime;
                order[index++] = node.index;
            }
            /**
             * After processing the frame from the pq, add starving frames from the queue to pq
             */
            while (!queue.isEmpty() && queue.peek().enqueueTime <= endTime) {
                pq.add(queue.poll());
            }
            /**
             * If no starving frame is added to pq, get the next frame from the queue.
             * This happens in the following example:
             * If the endTime is 10:
             * [11,12][11,13],[15,6]
             *
             */
            if (pq.isEmpty() && !queue.isEmpty()) {
                int newEnqueueTime = queue.peek().enqueueTime;

                while (!queue.isEmpty() && queue.peek().enqueueTime == newEnqueueTime) {
                    pq.add(queue.poll());
                }
                endTime = newEnqueueTime;
            }
        }
        return order;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
