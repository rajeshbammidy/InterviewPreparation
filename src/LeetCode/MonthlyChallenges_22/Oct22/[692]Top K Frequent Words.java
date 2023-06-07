package LeetCode.MonthlyChallenges_22.Oct22;//Given an array of strings words and an integer k, return the k most frequent
//strings. 
//
// Return the answer sorted by the frequency from highest to lowest. Sort the 
//words with the same frequency by their lexicographical order. 
//
// 
// Example 1: 
//
// 
//Input: words = ["i","love","leetcode","i","love","coding"], k = 2
//Output: ["i","love"]
//Explanation: "i" and "love" are the two most frequent words.
//Note that "i" comes before "love" due to a lower alphabetical order.
// 
//
// Example 2: 
//
// 
//Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"],
// k = 4
//Output: ["the","is","sunny","day"]
//Explanation: "the", "is", "sunny" and "day" are the four most frequent words, 
//with the number of occurrence being 4, 3, 2 and 1 respectively.
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 500 
// 1 <= words[i].length <= 10 
// words[i] consists of lowercase English letters. 
// k is in the range [1, The number of unique words[i]] 
// 
//
// 
// Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space? 
//
// Related Topics Hash Table String Trie TopicWiseSolutions.Strings.Sorting Heap (Priority TopicWiseSolutions.Strings.Queue) Bucket
//Sort Counting 👍 6246 👎 291


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        TreeMap<Integer, LinkedList<String>> tmap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (tmap.get(entry.getValue()) == null) {
                tmap.put(entry.getValue(), new LinkedList<>());

            }
            tmap.get(entry.getValue()).add(entry.getKey());
        }

        List<String> ans = new ArrayList<>();
        for (Map.Entry<Integer, LinkedList<String>> entry : tmap.entrySet()) {
            if (entry.getValue().size() > 1) {
                int i = 0;
                while (i < entry.getValue().size()) {
                    ans.add(entry.getValue().get(i++));
                    k--;
                    if (k == 0) return ans;
                }
            } else {
                ans.add(entry.getValue().get(0));
                k--;
                if (k == 0) return ans;
            }


        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
