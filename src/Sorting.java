import java.util.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Aug,2019
 * Happy Coding :)
 */
public class Sorting {
    public static void main(String[] args) {
        int arr[]={0, -1, 2, -3, 1};
        Arrays.sort(arr);
        int cn=0;
        for(int i=0;i<arr.length;i++){
            int sum=arr[i];
           cn+= findSum(sum,i+1,arr.length-1,arr);
        }
        System.out.println(cn);
    }

    private static int findSum(int sum, int i, int n, int[] arr) {


        while(i<n){
            if(arr[i]+arr[n]==sum){
                return 1;
            }
            else if(arr[i]+arr[n]>sum)n--;
            else if(arr[i]+arr[n]<sum)i++;

        }
       return 0;
    }
}
