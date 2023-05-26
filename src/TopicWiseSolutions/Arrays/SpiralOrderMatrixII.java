package TopicWiseSolutions.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Arrays|SpiralOrderMatrixII| on Dec,2019
 * Happy Coding :)
 *
 * Spiral Order Matrix II
 * Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.
 *  Input Format:
 * The first and the only argument contains an integer, A.
 * Output Format:
 * Return a 2-d matrix of size A x A satisfying the spiral order.
 * Constraints:
 * 1 <= A <= 1000
 * Examples:
 * Input 1:
 *     A = 3
 *
 * Output 1:
 *     [   [ 1, 2, 3 ],
 *         [ 8, 9, 4 ],
 *         [ 7, 6, 5 ]   ]
 *
 * Input 2:
 *     4
 *
 * Output 2:
 *     [   [1, 2, 3, 4],
 *         [12, 13, 14, 5],
 *         [11, 16, 15, 6],
 *         [10, 9, 8, 7]   ]
 */
public class SpiralOrderMatrixII {
    public static int[][] generateMatrix(int n) {

        int total = n * n;//n*n elements will be there
        int arr[][] = new int[n][n];
        int cnt = 1;
        int i1 = 0;//Represent the number of col/rows we are skipping from the end
        int i2 = 1;//represent the ith row from top
        int i3 = n - 2;//represents the ith column from the right
        int i4 = n - 2;//represent the ith row from down
        while (cnt <= total) {

            /*
            Traverses the top row
             */
            for (int i = i1; i < n - i1; i++) {
                arr[i1][i] = cnt++;
            }
            if (cnt > total) break;

            /***
             * Traverses the right most col from top to bottom
             */
            for (int i = i2; i < n - i1; i++) {
                arr[i][n - i1 - 1] = cnt++;
            }
            if (cnt > total) break;

            /***
             * Traverses the bottom row
             */
            for (int i = i3; i >= i1; i--) {
                arr[n - i1 - 1][i] = cnt++;
            }
            if (cnt > total) break;

            /**
             * Traverse the left most col from bottom to top
             */
            for (int i = i4; i >= i1 + 1; i--) {
                arr[i][i1] = cnt++;
            }
            if (cnt > total) break;

            i1++;
            i2++;
            i3--;
            i4--;
        }
        return arr;

    }
}
