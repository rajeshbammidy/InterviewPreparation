package TopicWiseSolutions.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Arrays|SumOfAllSubmatrices| on Dec,2019
 * Happy Coding :)
 *
 * Sum of all Submatrices
 * Given a 2D Matrix of dimensions N*N, we need to return sum of all possible submatrices. Example Input
 * [ [1,1],
 *   [1,1] ]
 * Example Output
 * 16
 * Explanation
 * Number of submatrices with 1 elements = 4, so sum of all such submatrices = 4*1 = 4
 * Number of submatrices with 2 elements = 4, so sum of all such submatrices = 4*2 = 8
 * Number of submatrices with 3 elements = 0
 * Number of submatrices with 4 elements = 1, so sum of such submatrix = 4
 *
 * Total Sum = 4+8+4 = 16
 */
public class SumOfAllSubmatrices {
    public int solve(int[][] arr) {
        int sum = 0;
        int m = arr.length;
        int n = arr[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int p = (i + 1) * (j + 1);//p is the number of ways we can select a node from top left of arr[i][j]
                int q = (n - i) * (n - j);//q is the number of ways we can select a node from bottom right of arr[i][j]
                int k = p * q;//here k represent number of times that arr[i][j] appears in all the submatrices,once you got to know this you can simply mutliply the freq*arr[i][j] which will give arr[i][j] contribution in all the submatrices
                sum += (k * arr[i][j]);

            }
        }
        return sum;

    }
}
