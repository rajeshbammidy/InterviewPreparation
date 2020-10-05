package DynamicProgramming;

/**
 * Created by RajeshAatrayan|InterviewPreparation|DynamicProgramming|BestTimetoBuyandSellStockIV| on Oct,2020
 *  
 * Happy Coding :)
 **/
public class BestTimetoBuyandSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        if (k >= prices.length / 2)
            return getMaxProfit(prices);

        int[] profits = new int[prices.length];

        for (int i = 0; i < k; i++) {
            int minCost = Integer.MIN_VALUE;
            int maxProfit = 0;

            for (int j = 0; j < prices.length; j++) {
                minCost = Math.max(minCost,  profits[j]-prices[j]);
                maxProfit = Math.max(maxProfit, prices[j] + minCost);
                profits[j] = maxProfit;
            }
        }

        int maxProfit = profits[0];
        for (int i = 1; i < profits.length; i++)
            maxProfit = Math.max(maxProfit, profits[i]);

        return maxProfit;
    }

    int getMaxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        }

        return maxProfit;
    }
}
