package BinarySearch;

/**
 * Created by RajeshAatrayan|InterviewPreparation|BinarySearch|SingleElementinaSortedArray| on Apr,2020
 *  
 * Happy Coding :)
 **/
public class SingleElementinaSortedArray {
    public int solve(int[] arr) {

        if (arr.length == 1) return arr[0];
        int ans = binarySrch(arr);
        return ans;
    }

    private int binarySrch(int[] arr) {
        int beg = 0;
        int end = arr.length - 1;
        while (beg <= end) {
            int mid = (beg + end) / 2;

            if ((mid == 0 || arr[mid] != arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] != arr[mid + 1]))
                return arr[mid];
            if(mid%2==0){
                if(mid == arr.length - 1 || arr[mid]==arr[mid+1])beg=mid+1;
                else end=mid-1;
            }else{
                if(mid==0 || arr[mid]==arr[mid-1])beg=mid+1;
                else end=mid-1;
            }
        }
        return -1;
    }
}
