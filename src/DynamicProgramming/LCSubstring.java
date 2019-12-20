package DynamicProgramming;

import java.util.TreeSet;

/**
 * Created by RajeshAatrayan|InterviewPreparation|DynamicProgramming|LCSubstring.java| on Jul,2019
 * Happy Coding :)
 */
public class LCSubstring {
    public static void main(String[] args) {
        String str1 = "abcdaf";
        String str2 = "zbcdf";

        char row[] = new char[str2.length() + 1];
        char col[] = new char[str1.length() + 1];
        int x = 1;
        for (char c : str1.toCharArray()) col[x++] = c;
        x = 1;
        for (char c : str2.toCharArray()) row[x++] = c;
        int arr[][] = new int[row.length][col.length];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i < row.length; i++) {
            for (int j = 1; j < col.length; j++) {
                if (row[i] == col[j]) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                    set.add(arr[i][j]);
                }
            }
        }
        System.out.println(set.last());

    }
}
