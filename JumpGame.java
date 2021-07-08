// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// keep desntination as nums.length-1
// check if destination can be reached from previous index, if not check previous index, if yes update destionation

class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length<=1)
            return true;
        
        int destination = nums.length-1;
        
        for(int i=nums.length-2; i>=0; i--){
            if(i+nums[i]>=destination){
                destination = i;
            }
        }
        
        return destination==0;
    }
}