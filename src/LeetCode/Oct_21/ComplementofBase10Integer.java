package LeetCode.Oct_21;

/**
 * Created by RajeshAatrayan|InterviewPreparation|LeetCode.Oct_LeetCode|ComplementofBase10Integer| on Oct,2020
 *  
 * Happy Coding :)
 **/
public class ComplementofBase10Integer {
    public int bitwiseComplement(int n) {
        String bis = Integer.toBinaryString(n);
        String aux = "";
        for (char ch : bis.toCharArray()) {
            if (ch == '0') {
                aux += "1";
            } else {
                aux += "0";
            }
        }
        return Integer.valueOf(aux, 2);

    }
}
