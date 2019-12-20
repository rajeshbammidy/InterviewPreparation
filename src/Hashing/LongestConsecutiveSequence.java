package Hashing;

import java.util.HashSet;
import java.util.List;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Hashing|null.java| on Dec,2019
 * Happy Coding :)
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(final List<Integer> list) {

        HashSet<Integer> S = new HashSet<Integer>();
        int ans = 0;
        int n = list.size();
        // Hash all the array elements
        for (int i = 0; i < n; ++i)
            S.add(list.get(i));

        // check each possible sequence from the start
        // then update optimal length
        for (int i = 0; i < n; ++i) {
            // if current element is the starting
            // element of a sequence
            if (!S.contains(list.get(i) - 1)) {
                // Then check for next elements in the
                // sequence
                int j = list.get(i);
                while (S.contains(j))
                    j++;

                // update optimal length if this length
                // is more
                if (ans < j - list.get(i))
                    ans = j - list.get(i);
            }
        }
        return ans;
    }
}
