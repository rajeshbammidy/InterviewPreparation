package Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Arrays|AntiDiagonals| on Apr,2020
 *  
 * Happy Coding :)
 **/
public class AntiDiagonals {
    public static int[][] diagonal(int[][] arr) {
        int n = arr.length;
        int total = n + n;
        total -= 1;
        int res[][] = new int[total][total];

        int row = 0;
        int times = 0;
        int col = -1;
        int size = 0;
        while (times < total) {
            if (times >= n) {
                row++;
                col = n - 1;
                size--;
            } else {
                col++;
                size++;

            }
            int dp[] = new int[size];
            int k = 0;
            int i = row;
            int j = col;
            while (i < n && j >= 0) {
                dp[k++] = arr[i++][j--];
            }
            res[times] = dp;
            times++;

        }
        return res;
    }
}
