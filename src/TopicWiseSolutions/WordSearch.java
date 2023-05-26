package TopicWiseSolutions;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings|WordSearch| on Jul,2020
 *  
 * Happy Coding :)
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 *
 * Constraints:
 *
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 **/
public class WordSearch {
    static class node {
        int x;
        int y;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean exist(char[][] board, String word) {

        HashMap<Character, ArrayList<node>> hashMap = new HashMap<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = board[i][j];
                if (hashMap.containsKey(ch)) {
                    hashMap.get(ch).add(new node(i, j));
                } else {
                    ArrayList<node> list = new ArrayList<>();
                    list.add(new node(i, j));
                    hashMap.put(ch, list);
                }

            }
        }


        for (node obj : hashMap.get(word.charAt(0))) {
            boolean visited[][] = new boolean[board.length][board[0].length];
            if (search(0, obj.x, obj.y, word, board, visited)) return true;

        }
        return false;

    }

    private boolean search(int i, int x, int y, String word, char[][] board, boolean visited[][]) {


        visited[x][y] = true;
        if (i == word.length() - 1) {
            return board[x][y] == word.charAt(i);
        }
        if (isValid(x + 1, y, board.length, board[0].length) && !visited[x + 1][y] && board[x + 1][y] == word.charAt(i + 1)) {

            if (search(i + 1, x + 1, y, word, board, visited)) return true;

        }
        if (isValid(x, y + 1, board.length, board[0].length) && !visited[x][y + 1] && board[x][y + 1] == word.charAt(i + 1)) {

            if (search(i + 1, x, y + 1, word, board, visited)) return true;

        }
        if (isValid(x - 1, y, board.length, board[0].length) && !visited[x - 1][y] && board[x - 1][y] == word.charAt(i + 1)) {

            if (search(i + 1, x - 1, y, word, board, visited)) return true;

        }
        if (isValid(x, y - 1, board.length, board[0].length) && !visited[x][y - 1] && board[x][y - 1] == word.charAt(i + 1)) {

            if (search(i + 1, x, y - 1, word, board, visited)) return true;

        }
        visited[x][y] = false;
        return false;
    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

}
