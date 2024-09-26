// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length ==0 || nums.length==1)
            return true;
        
        int destination = nums.length-1;
        
        for(int i = nums.length-2; i>=0; i--){
            if(nums[i] + i >= destination){
                destination = i;
            }
        }
        return destination==0;
    }
}