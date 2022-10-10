package LeetCode.Sept21;

/**
 * Created by RajeshAatrayan|InterviewPreparation|LeetCode.Sept_LeetCode|ImageOverlap| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class ImageOverlap {

    public int largestOverlap(int[][] arrA, int[][] arrB) {
        int largestOverlapOnes = 0;
        for (int row = -arrA.length + 1; row < arrA.length; row++)
            for (int col = -arrA.length + 1; col < arrA.length; col++)
                largestOverlapOnes = Math.max(largestOverlapOnes, overlapOnes(arrA, arrB, row, col));
        return largestOverlapOnes;
    }

    private int overlapOnes(int[][] A, int[][] B, int rowOff, int colOff) {
        int count = 0;
        for (int row = 0; row < A.length; row++) {
            for (int col = 0; col < A[0].length; col++) {
                if ((row + rowOff < 0 || row + rowOff >= A.length) || (col + colOff < 0 || col + colOff >= A[0].length))
                    continue;
                if (A[row][col] + B[row + rowOff][col + colOff] == 2)
                    count++;
            }
        }

        return count;
    }

}
