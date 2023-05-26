package TopicWiseSolutions.Math_I;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Math_I|ExcelColumnTitle| on Dec,2019
 * Happy Coding :)
 *
 * Excel Column Title
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet. For example:
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 */
public class ExcelColumnTitle {
    public String convertToTitle(int num) {
        char arr[]=new char[26];
        char c='A';
        int i=0;
        while (c <= 'Z') {
            arr[i++]=c;
            c++;
        }
        String str="";
        while (num>0){
            int r=num%26;
            if(r==0){r=26;
                num=(num/26)-1;//this is important
            }else{
                num=num/26;
            }
            str+=arr[r-1];

        }
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new ExcelColumnTitle().convertToTitle(42));
    }
}
