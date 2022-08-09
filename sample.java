//****JUMP GAME****
// Time Complexity :O(N)
// Space Complexity :O(1);
// Did this code successfully run on Leetcode :y
// Any problem you faced while coding this :n;
class Solution {
    public boolean canJump(int[] nums) {
        
        //null case
        if(nums.length==0) return true;
        
        int n=nums.length;
        int target=n-1;
        
        for(int i=n-1;i>=0;i--)
        {
            if(nums[i]+ i >=target)
            {
                target=i;
            }
        }
        
        return target==0;
    }
}

// Your code here along with comments explaining your approach
