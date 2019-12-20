package Recursion;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Recursion|PermutationsOfString.java| on Jul,2019
 * Happy Coding :)
 */
public class PermutationsOfString {
    public static void main(String[] args) {
        permute("abc", 0, 2);
    }

    private static void permute(String str, int l, int r) {

        if (l == r) {
            System.out.println(str);
        } else {

            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);//we swap the chars's initially
                permute(str, l + 1, r);//calling the swap on the next char
                str = swap(str, l, i);//swap back the char here
            }
        }
    }

    //this method is to swap the char's in a string
    private static String swap(String str, int l, int i) {
        char ch[] = str.toCharArray();
        char temp = ch[l];
        ch[l] = ch[i];
        ch[i] = temp;
        return String.valueOf(ch);

    }
}
