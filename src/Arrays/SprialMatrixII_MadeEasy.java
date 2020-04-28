package Arrays;

public class SprialMatrixII_MadeEasy {
    public static int[][] generateMatrix(int m) {
        int arr[][] = new int[m][m];
        int c = 1;
        int total = m * m;
        int top = 0;
        int down = m - 1;
        int left = 0;
        int right = m - 1;
        int dir = 0;


        while (c <= total && top <= down && left <= right) {

            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    arr[top][i] = c++;
                }
                if (c == total) return arr;
                top++;
            } else if (dir == 1) {
                for (int i = top; i <= down; i++) {
                    arr[i][right] = c++;
                }
                if (c == total) return arr;
                right--;
            } else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    arr[down][i] = c++;
                }
                if (c == total) return arr;
                down--;
            } else {
                for (int i = down; i >= top; i--) {
                    arr[i][left] = c++;
                }
                if (c == total) return arr;
                left++;
            }

            dir = (dir + 1) % 4;


        }
        return arr;
    }
}
