package TopicWiseSolutions.Math_I;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Math_I|FindingPosition| on Dec,2019
 * Happy Coding :)
 */
public class FindingPosition {
    public int solve(int l) {
        //find the log(base 2) for the given number
        int p = (int) (Math.log(l) / Math.log(2));
        //2^p where p=is the logarithm value obtained
        return (int) (Math.pow(2, p));
    }
}
