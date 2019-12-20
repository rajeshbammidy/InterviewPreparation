/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Aug,2019
 * Happy Coding :)
 */
public class Inversion {
    public static void main(String[] args) {
        merge(new int[]{2,3,4,5,6},0,4);
        System.out.println(c);
    }
   static int c=0;
static int temp[]=new int[1000];
    private static void merge(int[] arr, int beg, int end) {
        if (beg<end){
            int mid=(beg+end)/2;
            merge(arr,beg,mid);
            merge(arr,mid+1,end);
            mergeSort(arr,beg,mid,end);
        }
    }

    private static void mergeSort(int[] arr, int b, int m, int end) {
        int in=b,i=b,j=m+1;
        while (i<=m && j<=end){
            if(arr[i]<=arr[j]){
                temp[in++]=arr[i++];
            }else if(arr[i]>arr[j]){
                temp[in++]=arr[j++];
                c=c+(m-i+1);
            }
        }
        if(i>m){
            while(j<=end){
                temp[in++]=arr[j++];
            }
        }
        else if(j>end){
            while (i<=m){
                temp[in++]=arr[i++];
            }
        }

        for(int k=b;k<in;k++){
            arr[k]=temp[k];
        }



    }
}
