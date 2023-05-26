package TopicWiseSolutions.DynamicProgramming;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.DynamicProgramming|LCSubseq.java| on Jul,2019
 * Happy Coding :)
 * <p>
 * Find longest common subsequence
 */
public class LCSubseq {
    public static void main(String[] args) {
        String str1 = "abcdaf";
        String str2 = "acbcf";

        char col[] = new char[str1.length() + 1];
        char row[] = new char[str2.length() + 1];
        int x = 1;
        for (char c : str1.toCharArray()) col[x++] = c;
        x = 1;
        for (char c : str2.toCharArray()) row[x++] = c;


        int arr[][] = new int[row.length][col.length];
        for (int i = 1; i < row.length; i++) {
            for (int j = 1; j < col.length; j++) {

                if (row[i] == col[j]) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }

            }
        }

        System.out.println(arr[row.length - 1][arr[0].length - 1]);
    }
}
