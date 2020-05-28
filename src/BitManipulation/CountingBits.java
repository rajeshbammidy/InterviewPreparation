package BitManipulation;

/**
 * Created by RajeshAatrayan|InterviewPreparation|BitManipulation|CountingBits| on May,2020
 *  
 * Happy Coding :)
 **/
public class CountingBits {
    public int[] countBits(int num) {
        int arr[] = new int[num + 1];
        if(num==0)return arr;
        arr[0] = 0;
        arr[1] = 1;
        int in = 0;
        for (int i = 1; i <= num; i++) {

            if ((i & i - 1) == 0) {
                in = 0;
                arr[i] = arr[in++] + 1;

            } else {
                arr[i] = arr[in++] + 1;
            }


        }

        return arr;


    }
}
