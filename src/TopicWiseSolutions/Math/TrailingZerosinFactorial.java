package TopicWiseSolutions.Math;

public class TrailingZerosinFactorial {
    public int trailingZeroes(int num) {
        int num2 = 0, num5 = 0;
        int a = num, b = num;
        while (a > 0) {
            a = a / 2;
            num2 += a;
            if (a < 2) break;


        }
        while (b > 0) {
            b = b / 5;
            num5 += b;
            if (b < 5) break;


        }
        return Math.min(num2, num5);
    }
}
