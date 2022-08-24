import java.util.*;

public class Main {

    public static void main(String[] args)
    {

        int arr[]={1,7,11,13};
       ArrayList<Double> d = new ArrayList<>();
       HashMap<Double,String> map=new HashMap<>();
        for (int i = 0; i <arr.length ; i++) {
            for (int j =i+1; j < arr.length; j++) {
                double ff=((double)(arr[i])/arr[j]);
                d.add(ff);
                map.put(ff,arr[i]+"/"+arr[j]   );
                System.out.println();
            }
        }
        Collections.sort(d);
        for(double x:d){
            System.out.println(x + " "+map.get(x));
        }

    }

}