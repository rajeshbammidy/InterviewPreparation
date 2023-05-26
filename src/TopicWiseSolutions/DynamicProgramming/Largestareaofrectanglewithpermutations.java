package TopicWiseSolutions.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.DynamicProgramming|Largestareaofrectanglewithpermutations| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class Largestareaofrectanglewithpermutations {
    public int solve(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int mat[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0) {
                    mat[i][j] = arr[i][j];
                    continue;
                }

                if (arr[i][j] == 1) {
                    mat[i][j] = mat[i - 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            Arrays.sort(mat[i]);
        }
        int area = 0;
        for (int i = 0; i < m; i++) {
            int w = 1;

            for (int j = n - 1; j >= 0; j--) {

                int curArea = mat[i][j] * w;
                area = Math.max(area, curArea);
                w++;
            }

        }
        return area;

    }
}
