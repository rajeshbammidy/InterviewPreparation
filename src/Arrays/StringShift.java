package Arrays;

public class StringShift {
    public String stringShift(String str, int[][] shift) {

        int val = 0;
        for (int i = 0; i < shift.length; i++) {
            val += shift[i][0] == 0 ? -shift[i][1] : shift[i][1];
        }
        val = val % str.length();
        int n = str.length();
        if (val > 0) {//Right shift
            return str.substring(n - val) + str.substring(0, n - val);
        } else {
            return str.substring(-val) + str.substring(0, -val);
        }

    }
}
