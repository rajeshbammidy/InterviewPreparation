package Hashing;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Hashing|null.java| on Dec,2019
 * Happy Coding :)
 * <p>
 * <p>
 * Given an array A of integers, find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array Note:
 * 1) Return the indices `A1 B1 C1 D1`, so that
 * A[A1] + A[B1] = A[C1] + A[D1]
 * A1 < B1, C1 < D1
 * A1 < C1, B1 != D1, B1 != C1
 * <p>
 * 2) If there are more than one solutions,
 * then return the tuple of values which are lexicographical smallest.
 * <p>
 * Assume we have two solutions
 * S1 : A1 B1 C1 D1 ( these are values of indices int the array )
 * S2 : A2 B2 C2 D2
 * <p>
 * S1 is lexicographically smaller than S2 iff
 * A1 < A2 OR
 * A1 = A2 AND B1 < B2 OR
 * A1 = A2 AND B1 = B2 AND C1 < C2 OR
 * A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
 * Example:
 * Input: [3, 4, 7, 1, 2, 9, 8]
 * Output: [0, 2, 3, 5] (O index)
 * If no solution is possible, return an empty list.
 */
public class Equal {
    public ArrayList<Integer> equal(ArrayList<Integer> list) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int sum = list.get(i) + list.get(j);

                if (map.containsKey(sum)) {

                    String str[] = map.get(sum).split("\\s");
                    int a2 = Integer.parseInt(str[0]);
                    int b2 = Integer.parseInt(str[1]);
                    if (a2 < b2 && i < j && a2 < i && b2 != j && b2 != i) {
                        if (res.isEmpty()) {
                            res.add(a2);
                            res.add(b2);
                            res.add(i);
                            res.add(j);
                            continue;
                        }

                        int a1 = res.get(0);
                        int b1 = res.get(1);
                        int c1 = res.get(2);
                        int d1 = res.get(3);

                        int c2 = i, d2 = j;
                        if (a1 < a2 || (a1 == a2 && b1 < b2) || (a1 == a2 && b1 == b2 && c1 < c2) || (a1 == a2 && b1 == b2 && c1 == c2 && d1 < d2)) {

                        } else {
                            res.clear();
                            res.add(a2);
                            res.add(b2);
                            res.add(c2);
                            res.add(d2);
                        }


                    }
                } else {
                    map.put(sum, i + " " + j);
                }

            }
        }
        return res;
    }

}
