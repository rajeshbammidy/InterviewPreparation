package TopicWiseSolutions.Arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        left[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i];
        }
        right[right.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = nums[i] * right[i + 1];
        }
        int ans[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int t=1;
            if(i-1>=0){
                t=t*left[i-1];
            }
            if(i+1<nums.length){
                t=t*right[i+1];
            }
            ans[i]=t;
        }
        return ans;

    }
}
