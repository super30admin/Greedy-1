// Time Complexity : 0(n) 
// Space Complexity : 0(1) 

class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }
        int jumps = 1;
        int currInterval = nums[0];
        int nextInterval = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nextInterval = Math.max(nextInterval, nums[i] + i);
            if (i < nums.length - 1 && i == currInterval) {
                jumps++;
                currInterval = nextInterval;
            }
        }
        return jumps;       
    }
}