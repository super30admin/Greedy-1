// Time complexity :O(n)
// Space Complexity :O(1) 
class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int curMax = nums[0];
        int nextMax = nums[0];
        int jumps = 1;
        for (int i = 1; i < nums.length; i++) {
            nextMax = Math.max(nextMax, i + nums[i]);
            if (i == curMax && i != nums.length - 1) {
                jumps++;
                curMax = nextMax;
            }
            if (curMax >= nums.length - 1) break;
        }
        return jumps;
    }
}
