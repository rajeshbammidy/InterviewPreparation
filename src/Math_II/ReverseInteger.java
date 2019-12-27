package Math_II;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Math_II|ReverseInteger| on Dec,2019
 * Happy Coding :)
 * Reverse integer
 * Reverse digits of an integer. Example1: x = 123, return 321 Example2: x = -123, return -321 Return 0 if the result overflows and does not fit in a 32 bit signed integer
 */
public class ReverseInteger {
    public static int reverse(int num) {

        int sign = num < 0 ? -1 : 1;
        String str = "";
        if (sign == -1) str = (num + "").substring(1);

        else str = num + "";

        int ans = 0;
        num = Math.abs(num);
        while (num > 0) {
            ans = ans * 10 + num % 10;
            num = num / 10;

        }
        try {

            if (sign == -1) {
                String var = "-" + new StringBuilder(str).reverse().toString();
                int a = Integer.parseInt(var);
            } else {
                int a = Integer.parseInt(str);
            }

        } catch (Exception e) {
            return 0;
        }
        return sign*ans;
    }
}
