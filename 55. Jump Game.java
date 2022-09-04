// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: YES
// Any problem you faced while coding this: NO

class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length < 2) return true;
        
        int n = nums.length;
        int destination = n - 1;
        
        for(int i = n - 2; i >= 0; i--){
            if(i + nums[i] >= destination){
                destination = i;
            }
        }
        return destination == 0;
    }
}