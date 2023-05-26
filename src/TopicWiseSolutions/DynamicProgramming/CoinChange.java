package TopicWiseSolutions.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int coins[], int total) {
        int temp[][] = new int[coins.length+1][total+1];
        for(int i=0; i <= coins.length; i++){
            temp[i][0] = 1;
        }
        for(int i=1; i <= coins.length; i++){
            for(int j=1; j <= total ; j++){
                if(coins[i-1] > j){
                    temp[i][j] = temp[i-1][j];
                }
                else{
                    temp[i][j] = temp[i][j-coins[i-1]] + temp[i-1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(temp));
        return temp[coins.length][total];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            bf.readLine();


            String iws[] = bf.readLine().split("\\s");
            int wt[] = new int[iws.length];

            for (int j = 0; j < wt.length; j++) {
                wt[j] = Integer.parseInt(iws[j]);
            }
            int sum = Integer.parseInt(bf.readLine());
            System.out.println(coinChange(wt, sum));
        }

    }
}
