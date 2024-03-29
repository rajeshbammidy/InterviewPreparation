package LeetCode.MonthlyChallenges_23.Jan23;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a 0-indexed integer array tasks, where tasks[i] represents the
 * difficulty level of a task. In each round, you can complete either 2 or 3 tasks of
 * the same difficulty level.
 *
 * Return the minimum rounds required to complete all the tasks, or -1 if it is
 * not possible to complete all the tasks.
 *
 *
 * Example 1:
 *
 *
 * Input: tasks = [2,2,3,3,2,4,4,4,4,4]
 * Output: 4
 * Explanation: To complete all the tasks, a possible plan is:
 * - In the first round, you complete 3 tasks of difficulty level 2.
 * - In the second round, you complete 2 tasks of difficulty level 3.
 * - In the third round, you complete 3 tasks of difficulty level 4.
 * - In the fourth round, you complete 2 tasks of difficulty level 4.
 * It can be shown that all the tasks cannot be completed in fewer than 4 rounds,
 * so the answer is 4.
 *
 *
 * Example 2:
 *
 *
 * Input: tasks = [2,3,3]
 * Output: -1
 * Explanation: There is only 1 task of difficulty level 2, but in each round, you
 * can only complete either 2 or 3 tasks of the same difficulty level. Hence, you
 * cannot complete all the tasks, and the answer is -1.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= tasks.length <= 10⁵
 * 1 <= tasks[i] <= 10⁹
 *
 *
 * Related Topics Array Hash Table TopicWiseSolutions.Greedy Counting 👍 2183 👎 60
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution2244 {
    public int minimumRounds(int[] tasks) {
        int rounds = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : tasks) map.put(x, map.getOrDefault(x, 0) + 1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            while (value > 0) {
                if (value < 2) return -1;
                if (value % 3 == 0) {
                    rounds += 1;
                    value -=3;

                } else if (value % 2 == 0) {
                    rounds += 1;
                    value -=2;

                } else {
                    rounds += 1;
                    value -= 3;
                }
            }

        }
        return rounds;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
