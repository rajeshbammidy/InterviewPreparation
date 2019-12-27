package Math_I;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Math_I|ExcelColumnNumber| on Dec,2019
 * Happy Coding :)
 *
 * Excel Column Number
 * Given a column title as appears in an Excel sheet, return its corresponding column number. Example:
 *     A -> 1
 *
 *     B -> 2
 *
 *     C -> 3
 *
 *     ...
 *
 *     Z -> 26
 *
 *     AA -> 27
 *
 *     AB -> 28
 */
public class ExcelColumnNumber {

    public int titleToNumber(String str) {

        int l=str.length();
        str=new StringBuilder(str).reverse().toString();//reversing the string for easy traversal
        int sum=0;
        for(int i=0;i<l;i++){
            /**
             * CHAR-'A'+1 will give you the alphabetical ordering number like for A=1,B=2....
             */
            sum+=((Math.pow(26,i))*(str.charAt(i)-'A'+1));
        }
        return sum;
    }
}
