// Time Complexity : O(n^n) as for n value we can make n jumps
// Space Complexity : O(n) as max n elements can be present in a stack during a recursive call
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : TLE


// Your code here along with comments explaining your approach

class Solution {
    public boolean canJump(int[] nums) {
        //edge case
        if(nums== null || nums.length<2)
            return true;
    
       return dfs(nums,0); // taking first index
    }
    
    private boolean dfs(int[] nums, int index)
    {
        //base
        if(index == nums.length) // reached end
            return true;
        //logic
        for(int jump=1;jump<=nums[index];jump++) // take jumps equal to nums[index]
        {
            if(dfs(nums, index+jump)) return true; // if we get a path return true
        }
        return false;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    public boolean canJump(int[] nums) {
        //edge
        if(nums== null || nums.length<2)
            return true;
        int n = nums.length;
        int destination = n-1; // where we want to go
        
        for(int i=n-2;i>=0;i--) // iterating backward 
        {
            if(nums[i]+i >=destination) //checking if we can reach the destination from the current index by making nums[i] jumps
                destination=i; // if we can we update the destination as we now want to reach the current index
        }
        if(destination==0) // if we have reached the start of the array
            return true; // soln possible
        return false;
    }
}

// Time Complexity : O(n^n) as for n value we can make n jumps
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : TLE


// Your code here along with comments explaining your approach


class Solution {
    int min;
    public int jump(int[] nums) {
        //base
        if(nums==null || nums.length<2)
            return 0;
        min = Integer.MAX_VALUE; // finding min no of jumps
        dfs(nums,0,0); // calling dfs on nums based on index and jumps
        return min;
    }
    private void dfs(int[] nums, int i, int jumps)
    {
        //base
        if(i>=nums.length-1) // when overshoot
        {
            min=Math.min(min,jumps); // update min
            return;
        }
        //logic
        for(int j=1;j<=nums[i];j++) // take jumps equal to nums[i]
        {
            dfs(nums,i+j,jumps+1); // increasing index and updating the jumps
        }
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : TLE


// Your code here along with comments explaining your approach

class Solution {
    public int jump(int[] nums) {
        //edge case
        if(nums==null || nums.length==0)
            return 0;
            //to store no of steps min to reach the current destination
        int dp[] = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE); // prefilling array with max values
        dp[0]=0; // 0 steps to reach 
        for(int i=1; i<nums.length; i++) // starting at 1 index
        {
            for(int j=0; j<i; j++) // iterating from 0 to index and checking possible ways
            {
                if(nums[j]+j>=i) // if we can reach from j to i 
                    dp[i] = Math.min(dp[i], dp[j]+1); // we update min if we find a min jump path
            }
        }
       return dp[dp.length-1]; // give last value
        
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


class Solution {
    public int jump(int[] nums) {
        //edge case
        if(nums==null || nums.length<2)
            return 0;
        int jumps=1; // considering we always make a jump
        int currInt = nums[0]; // defining current and next interval based on initial number of jumps possible
        int nextInt = nums[0];
        //iterating over the nums 
        for(int i=1;i<nums.length;i++)
        {
            nextInt = Math.max(nextInt, i+nums[i]); // finding the next best interval if we can have one
            if(i<nums.length-1 && i==currInt) // if our current interval ends (avoiding jumping for last index by i<nums.length-1)
            {
                currInt = nextInt; // update the currint as next interval
                jumps++; // increase the jump for the nextinterval considered
            }
        }
        return jumps;
    }
}