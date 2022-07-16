package ScalerAcademy.binarySearch;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.binary_search / MaximumHeightOfStaircase
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 * Given an integer A representing the number of square blocks. The height of each square block is 1. The task is to create a staircase of max-height using these blocks.
 *
 * The first stair would require only one block, and the second stair would require two blocks, and so on.
 *
 * Find and return the maximum height of the staircase.
 *
 *
 *
 * Problem Constraints
 * 0 <= A <= 109
 *
 *
 * Input Format
 * The only argument given is integer A.
 *
 *
 *
 * Output Format
 * Return the maximum height of the staircase using these blocks.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 10
 * Input 2:
 *
 * A = 20
 *
 *
 * Example Output
 * Output 1:
 *
 * 4
 * Output 2:
 *
 * 5
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * The stairs formed will have height 1, 2, 3, 4.
 * Explanation 2:
 *
 * The stairs formed will have height 1, 2, 3, 4, 5.
 **/
public class MaximumHeightOfStaircase {

    public int solve(int nSquareBlocks) {
        long beg = 1;
        long end = nSquareBlocks;
        long ans = 0;
        while (beg <= end) {
            long mid = beg + (end - beg) / 2;
            long nSq = mid * (mid + 1) / 2;
            if (nSq <= nSquareBlocks) {
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (int) (beg-1);
    }
}
