package Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Arrays|RainWaterTrapped| on Dec,2019
 * Happy Coding :)
 *
 * Rain Water Trapped
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * Input Format
 * The only argument given is integer array A.
 * Output Format
 * Return the total water it is able to trap after raining..
 * For Example
 * Input 1:
 *     A = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output 1:
 *     6
 * Explaination 1:
 *
 *     In this case, 6 units of rain water (blue section) are being trapped.
 *
 */
public class RainWaterTrapped {
    public int trap(final int[] arr) {
        int leftMax[] = new int[arr.length];
        int rightMax[] = new int[arr.length];
        int max=0;
        for(int i=1;i<leftMax.length;i++){
            max=Math.max(max,arr[i-1]);
            leftMax[i]=max;
        }

        max=0;
        for(int i=arr.length-2;i>=0;i--){
            max=Math.max(max,arr[i+1]);
            rightMax[i]=max;
        }

        int ans=0;
        for(int i=0;i<arr.length;i++){

            int h=Math.min(leftMax[i],rightMax[i]);
            h=(h-arr[i]);
            if(h>=0)ans+=h;
        }
        return ans;
    }
}
