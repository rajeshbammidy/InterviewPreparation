class Solution {
        public int largestPerimeter(int[] nums) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        int n = nums.length - 1;
        while (n >= 0) {
            if (n - 1 >= 0 && n - 2 >= 0) {
                int a = nums[n ];
                int b = nums[n - 1];
                int c = nums[n - 2];
                if (b + c > a) return a + b + c;
            }
            n--;
        }
        return 0;
    }
}