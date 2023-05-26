package TopicWiseSolutions.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 1) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add("Q");
            res.add(temp);
            return res;
        }
        if (n == 2) return res;
        ArrayList<Integer> cols = new ArrayList<>();
        backtrack(n, res, 0, cols);
        return res;

    }

    private void backtrack(int n, List<List<String>> res, int row, ArrayList<Integer> cols) {

        if (row == n) {

            ArrayList<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = "";
                for (int j = 0; j < n; j++) {

                    if (cols.get(i) == j) {
                        str += "Q";
                    } else {
                        str += ".";
                    }

                }
                temp.add(str);

            }
            res.add(temp);

        }
        for (int i = 0; i < n; i++) {
            cols.add(i);
            if (isValid(cols)) {
                backtrack(n, res, row + 1, cols);
            }
            cols.remove(cols.size() - 1);
        }


    }

    private boolean isValid(ArrayList<Integer> cols) {
        int currentRow = cols.size() - 1;
        int currentCol = cols.get(currentRow);
        for (int i = 0; i < currentRow; i++) {
            int prevCol = cols.get(i);
            int diff = Math.abs(prevCol - currentCol);
			/**
			 * diff==0 -->indicates if they are on the same column
			 *
			 * diff==currentRow-i -->indicates if they are diagonal
			 */
			if (diff == 0 || diff == currentRow - i) return false;
        }
        return true;
    }
}
