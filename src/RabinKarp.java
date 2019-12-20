/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Sep,2019
 * Happy Coding :)
 */
public class RabinKarp {
    static boolean search(String pat, String txt, int q)
    {
        int plen=pat.length();
        int txlen=txt.length();
        if(txlen<plen)return false;
        int patHash=0;
        int txtHash=0;
        for(int i=0;i<pat.length();i++){
            patHash+=(pat.charAt(i)-'a'+1)*(int)Math.pow(10,plen-i-1);
            txtHash+=(txt.charAt(i)-'a'+1)*(int)Math.pow(10,plen-i-1);
        }
        if(patHash==txtHash)return pat.equals(txt.substring(0, pat.length()));
        int start=0;
        for(int i=pat.length();i<txt.length();i++){
            int ph=(txt.charAt(start)-'a'+1)*(int)Math.pow(10,plen-1);
            txtHash=(txtHash-ph)*10+(txt.charAt(i)-'a'+1);
            start++;
            if(patHash==txtHash)return pat.equals(txt.substring(start,i+1));

        }
        return false;

    }
    public static void main(String[] args) {
        search("ddee","aabbccddeeddff",10);
        int arr[];
        arr=new int[10];
    }
}
