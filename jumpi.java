// Time Complexity : 0(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){
            return true;
        }
        int destination = nums.length - 1;
        int n = nums.length;
        for(int i = n - 2; i >=0; i--){
            if(i + nums[i] >= destination){
                destination = i; // new destination as we can reach this
            }
        }

        return destination == 0; // back to start.
    }
}