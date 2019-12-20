import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Aug,2019
 * Happy Coding :)
 */
public class CountSort {
    public static void main(String[] args) {

        System.out.println(triplet());
    }

    private static int triplet() {
        int arr[]={4 ,-16 ,43, 4, 7, -36, 18};
        Arrays.sort(arr);
        int c=0;
        int beg=0;
        int end=arr.length-1;

        for(int i=0;i<=end;i++){
           if(check(-arr[i],i+1,end,arr)) {
              c++;
               System.out.println("sum "+-arr[i]);
           }
        }
        return c;
    }

    private static boolean check(int sum, int s, int j,int arr[]) {
        for(int i=s;i<j;i++){
            if(arr[i]+arr[j]==sum){
                System.out.println(arr[i]+" "+arr[j]);
                return true;
            }
            else if(arr[i]+arr[j]<sum)continue;
            else if(arr[i]+arr[j]>sum)j--;
        }
        return false;
    }


}
