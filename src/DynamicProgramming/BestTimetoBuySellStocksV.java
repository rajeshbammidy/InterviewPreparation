package DynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * Created by RajeshAatrayan|InterviewPreparation|DynamicProgramming|BestTimetoBuySellStocksV| on Oct,2020
 *  
 * Happy Coding :)
 **/
public class BestTimetoBuySellStocksV {
    public static int maximumCommissionFeeProfit(List<Integer> buy, List<Integer> sell, int k) {
        if (buy == null || buy.size() == 0)
            return 0;

        if (k == buy.size() / 2)
            return getMaxProfit(buy, sell);

        int[] profits = new int[buy.size()];

        for (int i = 0; i < k; i++) {
            int minCost = Integer.MIN_VALUE;
            int maxProfit = 0;
            int bs = -1;

            for (int j = 0; j < buy.size(); j++) {
                if (maxProfit < sell.get(j) + minCost) {
                    maxProfit = sell.get(j) + minCost;
                }
                if (j != 0) {
                    if (minCost < profits[j - 1] - buy.get(j)) {
                        minCost = profits[j - 1] - buy.get(j);

                    }
                } else {
                    minCost = -buy.get(j);
                }


                profits[j] = maxProfit;
            }
            System.out.println(Arrays.toString(profits));
        }

        int maxProfit = profits[0];
        for (int i = 1; i < profits.length; i++)
            maxProfit = Math.max(maxProfit, profits[i]);

        return maxProfit;

    }

    private static int getMaxProfit(List<Integer> buy, List<Integer> sell) {

        int maxProfit = 0;
        for (int i = 1; i < buy.size(); i++) {
            if (sell.get(i) > buy.get(i - 1))
                maxProfit += sell.get(i) - buy.get(i - 1);
        }

        return maxProfit;
    }

}
