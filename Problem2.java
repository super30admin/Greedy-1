/*
    LC - 45. Jump Game II
    TC - O(n)
    SC - O(1)
*/

class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int jumps = 1;
        int currInterval = nums[0];
        int nextInterval = nums[0];
        int n = nums.length;
        for(int i=1; i<n; i++) {
            nextInterval = Math.max(nextInterval, nums[i] + i);
            if(i == currInterval && i < n - 1) {
                jumps++;
                currInterval = nextInterval;
            }
        }
        return jumps;
    }
}