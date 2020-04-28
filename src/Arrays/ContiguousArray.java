package Arrays;

import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=(nums[i]==0?-1:1);
            if(map.containsKey(sum)){
                ans=Math.max(ans,i-map.get(sum));
            }else if(sum==0){
                ans=Math.max(ans,i+1);
            }
            else{
                map.put(sum,i);
            }
        }
        return ans;

    }
}
