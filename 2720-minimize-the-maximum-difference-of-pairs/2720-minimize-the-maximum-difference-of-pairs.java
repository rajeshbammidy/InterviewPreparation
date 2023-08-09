class Solution {

    /**
    Intution:
    1.Since they are asking min difference we should sort the array
    2. After sorting, we may take the consective abosolute difference and store it in maxHeap to find the max of min's.But it would be difficult to find the p such minimum pairs
    [3,4,2,3,2,1,2] -> [1,2,2,2,3,3,4]
    3.So we binarySearch on the answer.
     */
    static boolean isPossible(int nums[], long diff, int p) {
        int currentPairs = 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            long cdiff = Math.abs(nums[i] - nums[i - 1]);
            if (cdiff <= diff) {
                i++;
                currentPairs++;
            }
            if (currentPairs >= p) return true;
        }
        return false;
    }

    public static int minimizeMax(int[] nums, int p) {
        if (p == 0) return 0;
        int n = nums.length;
        Arrays.sort(nums);
        long beg = 0;
        long end = (long) (1e9);
        while (beg <= end) {
            long mid = beg + (end - beg) / 2;
            if (isPossible(nums, mid, p)) {
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return (int) (end + 1);
    }
}
