//TC - exponential
//SC - O(1)
//Problems Faced - TLE
//Greedy with Backtracking

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


//TC - O(n^2)
//SC - O(n^2)
//Problems Faced - MLE
// DP

class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) return true;
        
        Set<Integer> st = new HashSet<>();
        st.add(0);
        
        int[][] dp = new int[nums.length-1][nums.length];
        
        for(int i = 0; i < nums.length-1; ++i)
        {
            for(int j = 0; j < nums.length; ++j)
            {
                if(st.contains(i))
                {
                    if(j == i) dp[i][j] = 1;
                    else if(j > i)
                    {
                        if(j <= i + nums[i])
                        {
                            dp[i][j] = 1;
                            st.add(j);
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i < nums.length-1; i++)
        {
            if(dp[i][nums.length-1] == 1) return true;
        }
        
        return false;
    }
}

//TC - O(n)
//SC - O(1)

class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) return true;
        int dest = nums.length -1;
        int i = nums.length - 2;
        while(i >= 0)
        {
            if(i + nums[i] >= dest)
                dest = i;
            --i;
        }
        if(dest == 0) return true;
        return false;
    }
}
