package Recursion;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Recursion|SubsequenceOfString.java| on Jul,2019
 * Happy Coding :)
 * <p>
 * for a string of length n we wil have 2^n subseq strings
 */
public class SubsequenceOfString {
    public static void main(String[] args) {
        subseq("abc", "");
        //initiall output string is blank
    }

    private static void subseq(String str, String output) {
        if (str.isEmpty()) {
            System.out.println(output);
            return;
        }

        subseq(str.substring(1), output);
        subseq(str.substring(1), output + str.charAt(0));
    }
}
