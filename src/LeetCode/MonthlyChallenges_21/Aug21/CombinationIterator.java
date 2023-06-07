package LeetCode.MonthlyChallenges_21.Aug21;

/**
 * Created by RajeshAatrayan|InterviewPreparation|LeetCode.Aug_LeetCode|CombinationIterator| on Aug,2020
 *  
 * Happy Coding :)
 *
 * Design an Iterator class, which has:
 *
 * A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
 * A function next() that returns the next combination of length combinationLength in lexicographical order.
 * A function hasNext() that returns True if and only if there exists a next combination.
 *
 *
 * Example:
 *
 * CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.
 *
 * iterator.next(); // returns "ab"
 * iterator.hasNext(); // returns true
 * iterator.next(); // returns "ac"
 * iterator.hasNext(); // returns true
 * iterator.next(); // returns "bc"
 * iterator.hasNext(); // returns false
 *
 *
 * Constraints:
 *
 * 1 <= combinationLength <= characters.length <= 15
 * There will be at most 10^4 function calls per test.
 * It's guaranteed that all calls of the function next are valid.
 **/

import java.util.*;

public class CombinationIterator {
    LinkedList<String> list;

    public CombinationIterator(String characters, int combinationLength) {

        list = new LinkedList<>();
        char arr[] = characters.toCharArray();
        int c = 0;

        int tot = (int) (Math.pow(2, characters.length()) - 1);
        for (int i = 0; i <= tot; i++) {
            c = 0;

            if (Integer.bitCount(i) == combinationLength) {
                int m = i;
                String str = "";
                while (m > 0) {
                    if ((m & 1) > 0) {
                        str = str + arr[c];
                    }
                    c++;
                    m >>= 1;
                }
                list.add(str);

            }
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

    }

    public String next() {
        return list.poll();


    }

    public boolean hasNext() {
        return list.size() > 0;
    }
}
