// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int dest = n-1;
        for(int i = n-2; i >= 0; i--){
            if(nums[i] + i >= dest){
                dest = i;
            }
        }
        return dest==0;
    }
}