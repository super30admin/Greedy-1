//TC - exponential
//SC - O(1)
//Problems Faced - TLE

class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) return true;
        
        return greedyBckTrk(nums, 0);
    }
    
    private boolean greedyBckTrk(int[] nums, int idx)
    {
        //base
        if(idx >= nums.length) return false;
        
        if(nums[idx] > nums.length || nums[idx] >= nums.length - idx - 1) return true;
        
        if(idx == nums.length - 1 || (idx + nums[idx]) == nums.length - 1) return true;
        
        if(nums[idx] == 0) return false;
        
        
        //logic
        boolean flag = false;
        
        for(int i = nums[idx]; i >= 1; --i)
        {
            if(idx + i < nums.length)
                flag = flag || greedyBckTrk(nums, idx + i);
        }
        
        return flag;
    }
}
