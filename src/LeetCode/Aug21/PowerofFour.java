package LeetCode.Aug21;

/**
 * Created by RajeshAatrayan|InterviewPreparation|LeetCode.Aug_LeetCode|PowerofFour| on Aug,2020
 *  
 * Happy Coding :)
 **/
public class PowerofFour {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        double d = Math.log(n) / Math.log(4);
        return Math.floor(d) == Math.ceil(d);

    }
}
