package BitManipulation;

/**
 * Created by RajeshAatrayan|InterviewPreparation|BitManipulation|HammingDistance| on Jul,2020
 *  
 * Happy Coding :)
 **/
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int ans=0;
        for(int i=0;i<32;i++){
            int sum=0;
            int hash=1<<i;
            sum=sum+((x&hash)>0?1:0);
            sum=sum+((y&hash)>0?1:0);
            if(sum==1)ans++;
        }
        return ans;

    }

    public static void main(String[] args) {

    }
}
