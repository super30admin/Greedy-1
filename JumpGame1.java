// Time Complexity :o(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : couldnt understand the stopping condition at first.


// Your code here along with comments explaining your approach
class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length==0) return true;
        int n = nums.length;
        int destination = n-1;
        for(int i = destination-1;i>=0;i--){
            
            if(nums[i]+i >= destination){
                destination = i;
            }
            
        }
        return destination==0;
    }
}