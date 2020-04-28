package Arrays;

import java.util.List;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Arrays|LeftmostColumnwithatLeastaOne| on Apr,2020
 *  
 * Happy Coding :)
 * <p>
 * (This problem is an interactive problem.)
 * <p>
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.
 * <p>
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
 * <p>
 * You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
 * <p>
 * BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
 * BinaryMatrix.dimensions() returns a list of 2 elements [rows, cols], which means the matrix is rows * cols.
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
 * <p>
 * For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[0,0],[1,1]]
 * Output: 0
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[0,0],[0,1]]
 * Output: 1
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[0,0],[0,0]]
 * Output: -1
 * Example 4:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols <= 100
 * mat[i][j] is either 0 or 1.
 * mat[i] is sorted in a non-decreasing way.
 **/
interface BinaryMatrix {
    public int get(int row, int col);

    public List<Integer> dimensions();
};
public class LeftmostColumnwithatLeastaOne {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int ans = dim.get(1) + 1;
        int col = dim.get(1);
        int row = dim.get(0);
        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && i < row && j >= 0 && j < col) {

            int t = binarySearch(binaryMatrix, 1, i, j);
            if (t != -1 && t < ans) {
                ans = t;
                j = t;
            }
            t--;

        }
        return ans;


    }

    private int binarySearch(BinaryMatrix binaryMatrix, int k, int row, int end) {
        int beg = 0;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            if (binaryMatrix.get(row, mid) == k && (mid - 1 < 0 || binaryMatrix.get(row, mid - 1) == 0)) {
                return mid;
            } else if (binaryMatrix.get(row, mid) < k) {
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
