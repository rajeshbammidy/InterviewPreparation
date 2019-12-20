import java.util.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Aug,2019
 * Happy Coding :)
 */
public class Triangles {
    static long findNumberOfTriangles(int arr[], int n)
    {
        Arrays.sort(arr);

        int c=0;
        for(int i=n-1;i>1;i--){

            int l=0,r=i-1;
            while (l<r){
                if(arr[l]+arr[r]>arr[i]){
                    c+=r-l;
                    r--;
                }
                else l++;
            }
        }
        return c;
    }



    public static void main(String[] args) {
        System.out.println(findNumberOfTriangles(new int[]{6,4,9,7,8},5));

    }
}
