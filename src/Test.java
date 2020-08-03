import org.omg.CORBA.INTERNAL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Struct;
import java.util.*;


public class Test {


    public static void main(String[] str) throws Exception {


    }

    int findIndex(int arr[]) {

        int l = arr.length - 1;

        int beg = 0, end = l;

        while (beg <= end) {

            int mid = beg + (end - beg) / 2;

            if (mid - 1 != 0 && arr[mid - 1] < arr[mid] && mid + 1 != arr.length && arr[mid + 1] < arr[mid]) return mid;

            else if (arr[mid] > arr[l]) beg = mid + 1;

            else end = mid - 1;

        }

        return 0;

    }

    public static int msolution(int N, int K) {
        int result = 0;
        while (N >= 3 && K > 0) {
            if (N % 2 == 0) {
                N -= 1;
            } else {
                N /= 2;
                K -= 1;
            }
            result += 1;
        }
        return result + N - 1;
    }

    public static String solution(String message, int k) {
        String arr[] = message.split("\\s");
        int curlen = 0;
        String curString = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() + curlen > k) return curString;
            if (curString.isEmpty()) {
                curString = arr[i];
                curlen = curString.length();
            } else {

                if (arr[i].length() + 1 + curlen > k) return curString;
                curString = curString + " " + arr[i];
                curlen = curString.length();

            }
        }

        return curString;
    }


}