import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Aug,2019
 * Happy Coding :)
 *
 */


public class Try {

    static void sortABS(int arr[], int n,int k)
    {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i:arr)list.add(i);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if(Math.abs(a-k)<Math.abs(b-k))return +1;
                else return -1;
            }
        });
        int i=0;
        for(int x:list)arr[i++]=x;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String input[]= str.split("\\s");
        char arr1[]=input[0].toCharArray();
        Arrays.sort(arr1);
        char arr2[]=input[0].toCharArray();
        Arrays.sort(arr2);
        if(String.valueOf(arr1).equals(String.valueOf(arr2))) System.out.println(true);
else System.out.println(false);
    }
}
