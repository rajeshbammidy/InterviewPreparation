package ScalerAcademy.arrays;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.arrays / SumOfAllSubmatrices
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/
public class SumOfAllSubmatrices {
    public int solve(int[][] array) {
        int sum = 0;
        int row = array.length;
        int col = array[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int topLeft = (i + 1) * (j + 1);
                int bottomRight = (row - i) * (col - j);
                sum += (topLeft * bottomRight * array[i][j]);
            }
        }
        return sum;
    }
}
