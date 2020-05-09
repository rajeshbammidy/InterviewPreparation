package BinarySearch;

/**
 * Created by RajeshAatrayan|InterviewPreparation|BinarySearch|IsPerfectSquare| on May,2020
 *  
 * Happy Coding :)
 **/
public class IsPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        if (num == 1 || num == 0) return false;
        long beg = 1;
        long end = num;
        while (beg <= end) {
            long mid = beg + (end - beg) / 2;
            if (mid * mid == num) return true;

            if (mid * mid < num) beg = mid + 1;
            else end = mid - 1;

        }
        return false;

    }
}
