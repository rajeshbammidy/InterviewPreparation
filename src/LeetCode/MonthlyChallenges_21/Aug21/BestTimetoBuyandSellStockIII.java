package LeetCode.MonthlyChallenges_21.Aug21;

/**
 * Created by RajeshAatrayan|InterviewPreparation|LeetCode.Aug_LeetCode|BestTimetoBuyandSellStockIII| on Aug,2020
 *  
 * Happy Coding :)
 **/
public class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        int fb = Integer.MIN_VALUE;
        int sb = Integer.MIN_VALUE;
        int fs = 0, ss = 0;
        for (int i = 0; i < prices.length; i++) {
            fb = Math.max(fb, -prices[i]);
            fs = Math.max(fs, fb + prices[i]);
            sb = Math.max(sb, fs - prices[i]);
            ss = Math.max(ss, sb + prices[i]);

        }
        return ss;

    }
}
