// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public boolean canJump(int[] nums) {
        int prev= nums.length-1;
        for(int i=nums.length-2;i>=0;i--){//check if we can reach the firstindex from last 
            if(i+nums[i]>=prev)
                prev=i;
        }
        
        return prev==0;
    }
}