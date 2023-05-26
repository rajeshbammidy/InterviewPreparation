package TopicWiseSolutions.Math;

public class PalindromeInteger {
    public static int isPalindrome(int num) {
        if(num<0)return 0;
        int d = 1;
        int n = num;
        while (n >= 10) {
            n = n / 10;
            d = d * 10;
        }


        while (num >0) {
            int l = num / d;
            int t = num % 10;
            if (l != t) return 0;
            num = (num % d) / 10;
            d = d / 100;
        }
        return 1;
    }
}
