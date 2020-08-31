package Aug_LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Aug_LeetCode|FindAllDuplicatesinanArray| on Aug,2020
 *  
 * Happy Coding :)
 **/
public class FindAllDuplicatesinanArray {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int index=Math.abs(nums[i]);
            if(nums[index%nums.length]<0){
                list.add(index);
            }else{
                nums[index%nums.length]=-nums[index%nums.length];
            }

        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println( findDuplicates(new int[]{4,3,2,7,8,2,3,1}));;
    }
}
