package DynamicProgramming;

import java.util.ArrayList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|DynamicProgramming|QueenAttack| on Jul,2020
 *  
 * Happy Coding :)
 *
 * On a N * M chessboard, where rows are numbered from 1 to N and columns from 1 to M, there are queens at some cells. Return a N * M array A, where A[i][j] is number of queens that can attack cell (i, j). While calculating answer for cell (i, j), assume there is no queen at that cell.
 *
 * Notes:
 *
 * Queen is able to move any number of squares vertically, horizontally or diagonally on a chessboard. A queen cannot jump over another queen to attack a position.
 * You are given an array of N strings, each of size M. Each character is either a 1 or 0 denoting if there is a queen at that position or not, respectively.
 * Expected time complexity is worst case O(N*M).
 * For example,
 *
 * Let chessboard be,
 * [0 1 0]
 * [1 0 0]
 * [0 0 1]
 *
 * where a 1 denotes a queen at that position.
 *
 * Cell (1, 1) is attacked by queens at (2, 1), (1,2) and (3,3).
 * Cell (1, 2) is attacked by queen at (2, 1). Note that while calculating this, we assume that there is no queen at (1, 2).
 * Cell (1, 3) is attacked by queens at (3, 3) and (1, 2).
 * and so on...
 *
 * Finally, we return matrix
 * [3, 1, 2]
 * [1, 3, 3]
 * [2, 3, 0]
 **/
public class QueenAttack {
    public ArrayList<ArrayList<Integer>> queenAttack(ArrayList<String> str) {
        int arr[][] = new int[str.size()][str.get(0).length()];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (str.get(i).charAt(j) == '1') {
                    arr[i][j] = 1;
                }
            }

        }

        int m = arr.length;
        int n = arr[0].length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            ans.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {


                ans.get(i).add(eightDimSearch(i, j, arr, m, n));

            }

        }
        return ans;

    }

    private int eightDimSearch(int Realx, int Realy, int[][] arr, int m, int n) {
        int X[] = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
        int Y[] = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int x = Realx;
            int y = Realy;
            while (x < n && y < m && x >= 0 && y >= 0) {
                x += X[i];
                y += Y[i];
                if (x < n && y < m && x >= 0 && y >= 0 && arr[x][y] == 1) {
                    /**
                     * Because one queen cannot jump on another
                     */
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
