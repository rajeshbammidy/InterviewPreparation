package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Hashing|null.java| on Dec,2019
 * Happy Coding :)
 * <p>
 * Find Rectangle in binary matrix
 * Given a binary matrix of integers A of size N x M consisting of only 0 or 1. you need to check whether there exists a square or rectangle in a square whose all four corners are 1. All four corners need to be distinct. If there exists such rectangle or square return 1, else return 0.
 * Input Format
 * The first argument given is the integer matrix A.
 * Output Format
 * Return 1 if there exists such rectangle/square whose all four corners are 1 else return 0.
 * Constraints
 * 1 <= N, M <= 200
 * 0 <= A[i] <= 1
 * For Example
 * Input 1:
 * A = [   [0, 1, 1]
 * [0, 1, 1]
 * [0, 1, 0]   ]
 * Output 1:
 * 1
 * Explanation 1:
 * [ [1, 1]
 * [1, 1] ]
 * There exists a square whose all corners are 1.
 * <p>
 * Input 2:
 * A = [   [0, 1, 1]
 * [0, 0, 1]
 * [0, 1, 0]   ]
 * Output 2:
 * 0
 */
public class BinaryMatrix {
    public int solve(final List<ArrayList<Integer>> list) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        int rows = list.size();
        int cols = list.get(0).size();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 1; j++) {
                for (int k = j + 1; k < cols; k++) {

                    if (list.get(i).get(j) == 1 && list.get(i).get(k) == 1) {

                        if (map.containsKey(j) && map.get(j).contains(k)) {
                            return 1;
                        }

                        if (!map.containsKey(j)) {
                            HashSet<Integer> set = new HashSet<>();
                            set.add(k);
                            map.put(j, set);
                        } else {
                            map.get(j).add(k);

                        }

                    }


                }
            }
        }
        return 0;
    }
}
