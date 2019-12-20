/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Aug,2019
 * Happy Coding :)
 */
public class Determinant {
    static int determinantOfMatrix(int mat[][], int n)
    {
        if(n==1)return mat[0][0];
        int sub[][]=new int[n][n];//to store the sub matrix
        int c;//for the first row traversal;
        int s=1;//to obtain the sign factor (-1)^(i+j)
        int det=0;
        for(c=0;c<n;c++){
            getSubMatrix(mat,sub,0,c,n);
            det=det+s*mat[0][c]*determinantOfMatrix(sub,n-1);
            s=-s;
        }

        return det;
    }

    private static void getSubMatrix(int[][] mat, int[][] sub, int s, int c, int n) {
        int i=0,j=0,row,col;

        for(row=0;row<n;row++){
            for(col=0;col<n;col++){

                if(row!=0 && col!=0){
                    sub[i][j++]=mat[row][col];//storig the submatrix elements into sub array
                }

                if(j==n-1){
                    j=0;
                    i++;
                }
            }
        }
    }


    public static void main(String[] args) {

    }
}
