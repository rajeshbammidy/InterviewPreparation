package TopicWiseSolutions.Math;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Math|SieveofEratosthenes| on Oct,2020
 *  
 * Happy Coding :)
 **/
public class SieveofEratosthenes {
    void sieveOfEratosthenes(int n) {
        boolean dp[] = new boolean[n + 1];
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!dp[i]) {
                for (int j = i * i; j < dp.length; j += i) {
                    dp[i] = true;
                }
            }

        }
        for (int i = 2; i < n; i++) {
            if (!dp[i]) System.out.println(i);
        }
    }
}
