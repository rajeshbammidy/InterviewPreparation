import java.util.HashSet;
import java.util.Scanner;

class InvalidInputException extends Exception {

}

class Employee {

    private int id = 0;
    private String name = null;
    private boolean male = true;

    Employee(int id, String name, boolean male) {
        super();
        this.id = id;
        this.name = name;
        this.male = male;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ",  male=" + male + "]";
    }

    @Override
    public int hashCode() {
        // Complete all relevent code
        return this.id;
    }


}

public class Test {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {

            int mask = (1 << i);
            int numZeroes = 0;
            int numOnes = 0;
            for (int j = 0; j < nums.length; j++) {

                if ((nums[j] & mask) == 0) {
                    numZeroes++;
                } else {
                    numOnes++;
                }

            }
            if (numOnes % 3 != 0) {
                ans = (ans | mask);
            }

        }
        return ans;

    }

    public static void main(String[] str) {
        System.out.println(new Test().singleNumber(new int[]{0,1,0,1,0,1,99}));
    }

}