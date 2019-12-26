package Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Arrays|BeggarsOutsideTemple| on Dec,2019
 * Happy Coding :)
 * <p>
 * Beggars Outside Temple
 * There are N (N > 0) beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to his faith and ability) to some K beggars sitting next to each other. Given the amount donated by each devotee to the beggars ranging from i to j index, where 1 <= i <= j <= N, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means. Example:
 * Input:
 * N = 5, D = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
 * <p>
 * Return: [10, 55, 45, 25, 25]
 * <p>
 * Explanation:
 * => First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]
 * <p>
 * => Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]
 * <p>
 * => Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]
 */
public class BeggarsOutsideTemple {
    /**
     * Naive approach will traversing every range and incrementing the range by the value
     * Optimized Approach:Increment the start with the given value and decrement the end(0 based index) by the given value.Finally add the values in the res array
     */
    public int[] solve(int n, int[][] arr) {
        int res[] = new int[n];
        for (int i = 0; i < arr.length; i++) {

            int start = arr[i][0] - 1;
            int end = arr[i][1];
            int val = arr[i][2];

            res[start] += val;
            if (val < res.length) res[end] -= val;
        }

        int sum = 0;
        for (int i = 0; i < res.length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        return res;

    }
}
