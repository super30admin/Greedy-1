// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    int[] dp;
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return true;
        int n = nums.length;
        int target = nums.length -1;
        for(int i = n-2; i >= 0; i--){
            if(i + nums[i] >= target){
                target = i;
            }
        }
        return target == 0;
    }
}