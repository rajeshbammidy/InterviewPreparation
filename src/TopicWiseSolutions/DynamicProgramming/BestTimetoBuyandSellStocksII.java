package TopicWiseSolutions.DynamicProgramming;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.DynamicProgramming|BestTimetoBuyandSellStocksII| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class BestTimetoBuyandSellStocksII {
    public int maxProfit(final int[] arr) {
        int buy = -1;
        int maxProfit = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length && buy == -1 && arr[i + 1] > arr[i]) {
                buy = arr[i];
            }
            if (i + 1 < arr.length && arr[i + 1] < arr[i] && buy != -1) {
                maxProfit += arr[i] - buy;
                buy = arr[i + 1];
            }
            if (buy != -1 && i == arr.length-1) {
                maxProfit += arr[i] - buy;
            }
        }
        return maxProfit;
    }
}
