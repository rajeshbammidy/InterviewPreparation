package TopicWiseSolutions.Hashing;

import java.util.LinkedHashSet;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Hashing|null.java| on Dec,2019
 * Happy Coding :)
 * <p>
 * Longest Substring Without Repeat
 * Given a string, find the length of the longest substring without repeating characters. Example: The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeat {

    public int lengthOfLongestSubstring(String str) {
        int max = Integer.MIN_VALUE;
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        int left = 0;
        int right = 0;
        for (right = 0; right < str.length(); ) {
            char ch = str.charAt(right);
            if (set.contains(str.charAt(right))) {
                set.remove(str.charAt(left++));
            } else {
                set.add(str.charAt(right++));
                max = Math.max(max, set.size());
            }
        }
        return max;
    }

}
