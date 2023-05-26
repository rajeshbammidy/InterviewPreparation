package TopicWiseSolutions.Math;

public class SortedPermutationRank {
    static  final int mod=1000003;
    public int findRank(String str) {
        long rank = 1;
        int n = str.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            int c = 0;

            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) > str.charAt(j))
                c++;
            }

            rank =(rank%mod +   ( c %mod  *  factorail(n-i)%mod)%mod)%mod;
        }
        return (int) (rank%mod);
    }

    private int factorail(int i) {
        long arr[] = new long[i + 1];
        arr[0] = 1;

        for (int j = 1; j < arr.length; j++) {
            arr[j] = (arr[j - 1]%mod * j%mod)%mod;
        }
        return (int) arr[i]%mod;
    }
}
