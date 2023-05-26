package ScalerAcademySolutions.heaps1;

import java.util.*;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.heaps1
 * Date:Aug, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 *
 *
 * Problem Description
 * Given two integers arrays, A and B, of size N each.
 *
 * Find the maximum N elements from the sum combinations (Ai + Bj) formed from elements in arrays A and B.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 2 * 105
 *
 * -1000 <= A[i], B[i] <= 1000
 *
 *
 *
 * Input Format
 * The first argument is an integer array A.
 * The second argument is an integer array B.
 *
 *
 *
 * Output Format
 * Return an integer array denoting the N maximum element in descending order.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 4, 2, 3]
 * B = [2, 5, 1, 6]
 * Input 2:
 *
 * A = [2, 4, 1, 1]
 * B = [-2, -3, 2, 4]
 *
 *
 * Example Output
 * Output 1:
 *
 * [10, 9, 9, 8]
 * Output 2:
 *
 * [8, 6, 6, 5]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * 4 maximum elements are 10(6+4), 9(6+3), 9(5+4), 8(6+2).
 * Explanation 2:
 *
 * 4 maximum elements are 8(4+4), 6(4+2), 6(4+2), 5(4+1).
 */
public class NMaxPairCombinations {
    static class Pair {
        private int x, y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashSet<String> set = new HashSet<>();
        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B, Collections.reverseOrder());
        int n = A.size();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return -new Integer(A.get(o1.x) + B.get(o1.y)).compareTo(A.get(o2.x) + B.get(o2.y));
            }
        });
        pq.add(new Pair(0, 0));
        set.add("0-0");
        ArrayList<Integer> ans = new ArrayList<>();
        while (n > 0 && !pq.isEmpty()) {
            Pair p = pq.poll();
            ans.add(A.get(p.x) + B.get(p.y));
            String LR = p.x + "-" + (p.y + 1);
            String RL = (p.x + 1) + "-" + (p.y);
            if (!set.contains(LR) && p.y + 1 < B.size()) {
                pq.add(new Pair(p.x, p.y + 1));
                set.add(LR);
            }
            if (!set.contains(RL) && p.x + 1 < A.size()) {
                pq.add(new Pair(p.x + 1, p.y));
                set.add(RL);
            }
            n--;
        }
        return ans;

    }

    public static void main(String[] args) {
        new NMaxPairCombinations().solve(new ArrayList<>(Arrays.asList(3, 4)), new ArrayList<>(Arrays.asList(3, 4)));
    }
}
