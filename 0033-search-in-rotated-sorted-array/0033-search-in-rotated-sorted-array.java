class Solution {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int beg = 0;
        int end = n - 1;
        while (beg <= end) {
            int mid = beg + ((end - beg) >> 2);
            System.out.println(nums[mid]);
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[beg]) {
                if (nums[mid] > target && nums[beg] <= target) end = mid - 1; else beg = mid + 1;
            } else {
                if (nums[mid] < target && nums[end] >= target) beg = mid + 1; else end = mid - 1;
            }
        }
        return -1;
    }
}
