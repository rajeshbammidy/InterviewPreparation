package BinarySearch;

/**
 * Created by RajeshAatrayan|InterviewPreparation|BinarySearch|AllocateBooks| on Apr,2020
 *  
 * Happy Coding :)
 **/
public class AllocateBooks {
    public int books(int[] pages, int kids) {
        long beg = 1;
        /**
         * Since atleast one book should be allocated to the student
         */
        long end = getMax(pages);
        long minPages = Integer.MAX_VALUE;
        while (beg <= end) {
            long mid = beg + (end - beg) / 2;
            if (getNumChild(pages, kids, mid)) {
                end = mid - 1;
                minPages = Math.min(minPages, mid);
            } else {
                beg = mid + 1;
            }
        }
        return (int) minPages;

    }

    private boolean getNumChild(int[] pages, int kids, long minNumOfPagesAllotted) {
        int kidsReq = 1;
        long sum = 0;
        for (int x : pages) {
            if (x > minNumOfPagesAllotted) return false;
            sum += x;
            if (sum > minNumOfPagesAllotted) {

                kidsReq += 1;
                sum = x;
            }
            if (kidsReq > kids) return false;
        }
        return true;
    }

    private long getMax(int[] pages) {
        long sum = 0;
        for (long x : pages) sum += x;
        return sum;
    }
}
