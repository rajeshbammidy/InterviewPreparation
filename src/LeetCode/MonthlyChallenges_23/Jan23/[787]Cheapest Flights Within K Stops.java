package LeetCode.MonthlyChallenges_23.Jan23;

import javafx.util.Pair;

import java.util.*;

/**
 * There are n cities connected by some number of flights. You are given an array
 * flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight
 * from city fromi to city toi with cost pricei.
 *
 * You are also given three integers src, dst, and k, return the cheapest price
 * from src to dst with at most k stops. If there is no such route, return -1.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]],
 * src = 0, dst = 3, k = 1
 * Output: 700
 * Explanation:
 * The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 3 is marked in red and has
 * cost 100 + 600 = 700.
 * Note that the path through cities [0,1,2,3] is cheaper but is invalid because
 * it uses 2 stops.
 *
 *
 * Example 2:
 *
 *
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
 *
 * Output: 200
 * Explanation:
 * The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 2 is marked in red and has
 * cost 100 + 100 = 200.
 *
 *
 * Example 3:
 *
 *
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
 *
 * Output: 500
 * Explanation:
 * The graph is shown above.
 * The optimal path with no stops from city 0 to 2 is marked in red and has cost 50
 * 0.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 100
 * 0 <= flights.length <= (n * (n - 1) / 2)
 * flights[i].length == 3
 * 0 <= fromi, toi < n
 * fromi != toi
 * 1 <= pricei <= 10⁴
 * There will not be any multiple flights between two cities.
 * 0 <= src, dst, k < n
 * src != dst
 *
 *
 * Related Topics Dynamic Programming Depth-First Search Breadth-First Search
 * Graph Heap (Priority TopicWiseSolutions.Strings.Queue) Shortest Path 👍 7254 👎 316
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution787 {
    private List<List<Pair<Integer, Integer>>> list;
    private HashSet<Integer> visited;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        list = new ArrayList<>();
        visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        buildGraph(list, flights);
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<Integer, Integer>(src, 0));
        int steps = k + 1;
        while (!queue.isEmpty() && steps > 0) {
            int size = queue.size();
            while (size-- > 0) {
                Pair<Integer, Integer> currentPair = queue.poll();
                for (Pair<Integer, Integer> p : list.get((Integer) currentPair.getKey())) {
                    if (dist[p.getKey()] > currentPair.getValue() + p.getValue()) {
                        dist[p.getKey()] = Math.min(dist[p.getKey()], (currentPair.getValue()) + p.getValue());
                        queue.add(new Pair<Integer, Integer>(p.getKey(), (currentPair.getValue()) + p.getValue()));
                    }

                }
            }
            steps--;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    private void buildGraph(List<List<Pair<Integer, Integer>>> list, int[][] flights) {
        for (int f[] : flights) {
            list.get(f[0]).add(new Pair<Integer, Integer>(f[1], f[2]));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
