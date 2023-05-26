package TopicWiseSolutions;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings|ReverseString| on Jun,2020
 *  
 * Happy Coding :)
 **/
public class ReverseString {
    public void reverseString(char[] str) {
        for(int i=0;i<str.length/2;i++){
            char c=str[i];
            char d=   str[str.length-i-1];
            str[str.length-i-1]=c;
            str[i]=d;

        }


    }
}
