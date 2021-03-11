// TC: O(N)
// SC: O(1)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int lastGoodPosition = n-1;
        
        for ( int i = n-2; i >= 0; i--)
        {
            if (i + nums[i] >= lastGoodPosition)
            {
                lastGoodPosition = i;
            }
        }
            
        return lastGoodPosition == 0;
    }
}

// TLE
// TC: Exponential
// SC: O(N) -> recursive stack size
// Did it run successfully on Leetcode? : TLE
class Solution {
    public boolean canJump(int[] nums) {
        if ( nums == null || nums.length == 0)
            return false;
        return dfs(nums, 0);
    }
    private boolean dfs(int[] nums, int index)
    {
        //base
        if ( index >= nums.length)
            return false;
        
        //logic
        for ( int j = 1; j <= nums[index] ; j++)
        {
            if (dfs(nums, index+j))
                return true;
        }
        return false;
    }
}
