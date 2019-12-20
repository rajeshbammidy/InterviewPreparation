package BitManipulation;

import java.util.Scanner;


/**
 * Created by RajeshAatrayan|InterviewPreparation|BitManipulation|FindFirstSetBit.java| on Aug,2019
 * Happy Coding :)
 */
public class FindFirstSetBit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();
        int pos = getFirstSetBitPos(val);
        System.out.println(pos + 1);
    }

    private static int getFirstSetBitPos(int val) {
        String str = new StringBuilder(Integer.toBinaryString(val)).reverse().toString();
        return str.indexOf("1");


    }
}
