package LeetCode.MonthlyChallenges_22.Nov22;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given an m x n board of characters and a list of strings words, return all
 * words on the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same letter
 * cell may not be used more than once in a word.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
 * "l","v"]], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 10⁴
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 * <p>
 * <p>
 * Related Topics Array String TopicWiseSolutions.Strings.Backtracking Trie Matrix 👍 7576 👎 346
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution212 {
    List<String> ans;
    //T,L,B,R
    final int xDir[] = {-1, 0, 1, 0};
    final int yDir[] = {0, -1, 0, 1};


    public List<String> findWords(char[][] board, String[] words) {
        ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }

        backtrack(board, "", 0, 0, set);
        return ans;
    }

    private void backtrack(char[][] board, String str, int i, int j, HashSet<String> set) {
        int m = board.length;
        int n = board[m].length;
        if (!isValid(i, j, m, n)) {
            return;
        }
        if (set.contains(str)) {
            ans.add(str);
        }

        if (isValid(i + xDir[0], j + yDir[0], m, n)) {
            backtrack(board, str + board[i][j], i + xDir[0], j + yDir[0], set);
        }
        if (isValid(i + xDir[1], j + yDir[1], m, n)) {
            backtrack(board, str + board[i][j], i + xDir[1], j + yDir[1], set);
        }
        if (isValid(i + xDir[2], j + yDir[2], m, n)) {
            backtrack(board, str + board[i][j], i + xDir[2], j + yDir[2], set);
        }
        if (isValid(i + xDir[3], j + yDir[3], m, n)) {
            backtrack(board, str + board[i][j], i + xDir[3], j + yDir[3], set);
        }

    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
