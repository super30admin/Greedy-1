// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public boolean canJump(int[] nums) {
        
        int lastPos = nums.length-1;
        
        for(int i=lastPos-1;i>=0;i--) {
            
            if(nums[i]+i>=lastPos) {
                lastPos=i;
            }
            
        }
        return lastPos==0;
    }
}
