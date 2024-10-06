// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean canJump(int[] nums) 
    {
        int target = nums.length -1;
        for(int i = nums.length-2; i >= 0; i--)
        {
            if(i + nums[i] >= target)
            {
                target = i;
            }
        }
        return target == 0;
    }
}