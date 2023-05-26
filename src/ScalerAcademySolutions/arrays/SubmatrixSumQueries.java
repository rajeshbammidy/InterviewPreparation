package ScalerAcademySolutions.arrays;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.arrays / SubmatrixSumQueries
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/
public class SubmatrixSumQueries {
    public int[] solve(int[][] array, int[] B, int[] C, int[] D, int[] E) {

        int mod = (int) (1e9 + 7);
        int rows = array.length;
        int col = array[0].length;
        long sumArray[][] = new long[rows][col];
        int n = B.length;// number of queries
        for (int j = 0; j < col; j++) sumArray[0][j] = array[0][j];

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                sumArray[i][j] = ((sumArray[i - 1][j] + array[i][j]) % mod + mod) % mod;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < col; j++) {
                sumArray[i][j] = ((sumArray[i][j] + sumArray[i][j - 1]) % mod + mod) % mod;
            }
        }
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            int tli = B[i] - 1;
            int tlj = C[i] - 1;
            int bri = D[i] - 1;
            int brj = E[i] - 1;
            long totalSum = sumArray[bri][brj];

            if (tli > 0) {
                totalSum = ((totalSum - sumArray[tli - 1][brj]) % mod + mod) % mod;
            }
            if (tlj > 0) {
                totalSum = ((totalSum - sumArray[bri][tlj - 1]) % mod + mod) % mod;
            }
            if (tli > 0 && tlj > 0) {
                totalSum = (((totalSum + sumArray[tli - 1][tlj - 1]) % mod + mod)) % mod;
            }
            res[i] = (int) totalSum;
        }


        return res;
    }
}
