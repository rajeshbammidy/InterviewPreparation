package Sorting;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Sorting|ReversePairs| on May,2020
 *  
 * Happy Coding :)
 **/
public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] arr, int beg, int end) {
        int c = 0;
        if (beg < end) {
            int mid = beg + (end - beg) / 2;
            c += mergeSort(arr, beg, mid);
            c += mergeSort(arr, mid + 1, end);
            c += merge(arr, beg, mid, end);
        }
        return c;
    }

    private int merge(int[] arr, int beg, int mid, int end) {

        int temp[] = new int[end + 1];
        int i = beg;
        int j = mid + 1;
        int c = 0;
        int index = i;
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[index++] = arr[i];
                i++;
            } else {
                int t=i;
                while (t<=mid){
                    long pf=arr[t++];
                    long lt=arr[j];
                    if(pf>2*lt)c++;
                }
                temp[index++] = arr[j];

                j++;
            }
        }

        if (i > mid) {
            while (j <= end) {
                temp[index++] = arr[j];
                j++;
            }
        }
        if (j > end) {
            while (i <= mid) {
                temp[index++] = arr[i];
                i++;
            }
        }
        for (i = beg; i <= end; i++) arr[i] = temp[i];
        return c;
    }

    public static void main(String[] args) {
System.out.println(new ReversePairs().reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));

    }
}
