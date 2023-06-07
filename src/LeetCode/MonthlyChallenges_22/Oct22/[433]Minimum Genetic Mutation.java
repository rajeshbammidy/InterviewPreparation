package LeetCode.MonthlyChallenges_22.Oct22;//A gene string can be represented by an 8-character long string, with choices
//from 'A', 'C', 'G', and 'T'. 
//
// Suppose we need to investigate a mutation from a gene string start to a gene 
//string end where one mutation is defined as one single character changed in the 
//gene string. 
//
// 
// For example, "AACCGGTT" --> "AACCGGTA" is one mutation. 
// 
//
// There is also a gene bank bank that records all the valid gene mutations. A 
//gene must be in bank to make it a valid gene string. 
//
// Given the two gene strings start and end and the gene bank bank, return the 
//minimum number of mutations needed to mutate from start to end. If there is no 
//such a mutation, return -1. 
//
// Note that the starting point is assumed to be valid, so it might not be 
//included in the bank. 
//
// 
// Example 1: 
//
// 
//Input: start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA",
//"AAACGGTA"]
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC",
//"AACCCCCC"]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// start.length == 8 
// end.length == 8 
// 0 <= bank.length <= 10 
// bank[i].length == 8 
// start, end, and bank[i] consist of only the characters ['A', 'C', 'G', 'T']. 
//
// 
//
// Related Topics Hash Table String Breadth-First Search 👍 1762 👎 182


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution433 {
    public int minMutation(String start, String end, String[] bank) {
        // if the length of start and end are not equal
        if (start.length() != end.length()) return -1;
        //TopicWiseSolutions.Strings.Queue to mutate one char at a time
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visitedGene = new HashSet<>();
        queue.add(start);
        visitedGene.add(start);
        int ans = 0;
        char geneChars[] = {'A', 'C', 'G', 'T'};
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int j = 0; j < len; j++) {
                if (end.equals(queue.peek())) return ans;
                String mutatedGene = queue.poll();
                for (int k = 0; k < geneChars.length; k++) {
                    for (int i = 0; i < mutatedGene.length(); i++) {
                        String afterMutation = new StringBuilder(mutatedGene.substring(0, i)).append(geneChars[k]).append(mutatedGene.substring(i + 1)).toString();
                        if (isMutationValid(afterMutation, bank) && !visitedGene.contains(afterMutation)) {
                            queue.add(afterMutation);
                            visitedGene.add(afterMutation);
                        }

                    }
                }

            }
            ans++;
        }
        return -1;
    }

    private boolean isMutationValid(String str, String[] bank) {

        return Arrays.asList(bank).contains(str);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
