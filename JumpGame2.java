//TC - exponential
//SC - O(1)
//Problems faced - TLE

class Solution {
    int minn;
    
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        if(nums.length == 2) return 1;
        
        minn = nums.length;
        
        dfs(nums, 0, 0);
        
        return minn;
    }
    
    private void dfs(int[] nums, int idx, int l)
    {
        //base
        if(idx == nums.length - 1 && l < minn)
        {
            minn = l;
            return;
        }
        
        if(idx >= nums.length) return;
        
        int leftover = nums.length - 1 - idx;
        
        if(nums[idx] >= leftover && (l+1) < minn)
        {
            minn = l + 1;
            return;
        }
        
        if(nums[idx] == 0) return;
        
        
        //logic
        for(int i = nums[idx]; i >= 1; --i)
        {
            if(idx + i < nums.length)
                dfs(nums, idx + i, l+1);
        }
    }
}
