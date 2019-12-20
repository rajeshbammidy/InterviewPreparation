import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

import static java.util.Arrays.binarySearch;

/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Aug,2019
 * Happy Coding :)
 */
public class One {

    public static void main(String[] args) throws  Exception {
        int arr[]={2 ,1 ,2 ,5 ,7 ,1 ,9 ,3 ,6 ,8 ,8};
        int arr2[]={2,1,8,3};
        ArrayList<Integer> list=new ArrayList<>();

        Arrays.sort(arr);
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int x:arr){
           if(map.get(x)==null)map.put(x,1);
           else{
              map.put(x,map.get(x)+1);
           }
        }
        for(int x:arr2){
            int lf=binarysearch(arr,x,0,arr.length-1);
            if(lf>-1){
                for(int i=0;i<map.get(x);i++){
                    list.add(x);
                }
            }
        }
        for(int x:arr){
            if(!list.contains(x))list.add(x);
        }

        System.out.println(list);

    }

    private static int binarysearch(int[] arr, int x, int i, int n) {
        int beg=0,end=n;
        int lf=-1;
        while (beg<=end){
            int mid=(beg+end)/2;

            if(arr[mid]==x &&(mid==0 || arr[mid-1]!=x)){
                lf=mid;
                break;
            }
            else  if(x<arr[mid])end=mid-1;
            else if(x>arr[mid])beg=mid+1;
        }
        if(lf==-1)return -1;
        return lf;
    }
}
