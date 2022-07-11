//https://leetcode.com/problems/jump-game/
// Time Complexity :O(n)  
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        int n=nums.length;
        int target=n-1;
        for(int i=n-2;i>=0;i--)
        {
            if(i+nums[i]>=target)
                target=i;
        }
        return target==0;
    }
}