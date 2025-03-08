class Jump2Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int n = nums.length, jumps = 1, currInterval = nums[0], nextInterval = nums[0];
        for (int i = 0; i < n; i++) {
            nextInterval = Math.max(nextInterval, i + nums[i]);
            if (i < n - 1 && i == currInterval) {
                jumps++;
                currInterval = nextInterval;
            }
        }
        return jumps;
    }
}