//Time Complexity:O(n)
//Space Complexity:O(1)
class Solution {
    public int jump(int[] nums) {
        if (nums.length < 2)
            return 0;
        int n = nums.length;
        int currInterval = nums[0];
        int nextInterval = nums[0];
        int jumps = 1;
        for (int i = 1; i < n; i++) {
            nextInterval = Math.max(nextInterval, i + nums[i]);
            if (i < n - 1 && currInterval == i) {
                jumps++;
                currInterval = nextInterval;
            }
        }
        return jumps;

    }
}