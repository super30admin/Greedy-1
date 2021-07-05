// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are iterating through the entire array only once
//Space Complexity: O(1) since we are using an extra space

class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return true;
        int destination = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(i + nums[i] >= destination){
                destination = i;
            }
        }
        
        return destination == 0;
    }
}