
class Sample {
    // Time Complexity : O(n) where n is size of array
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    /**
     * Approach:
     * 1. Start from end of the array since we only have to check if it is possible or not.
     * 2. check for each index position starting from 
     */
    public boolean canJump(int[] nums) {
        
        if(nums == null || nums.length < 2)
            return true;
        
        int destination = nums.length-1;
        
        for(int i=nums.length-2; i>=0; i--) {
            if(nums[i] + i >= destination) {
                destination = i;
            }
        }
        
        return destination == 0;
        // return dfs(nums, 0);
    }
    
    // public boolean dfs(int[] nums, int i) {
    //     //Base
    //     if(i >= nums.length-1)
    //         return true;
    //     //Logic
    //     for(int j=1; j<=nums[i]; j++) {
    //         if(dfs(nums, i+j)){
    //             return true;
    //         }
    //     }
        
    //     return false;
    // }


    // Time Complexity : O(n) where n is size of array
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    /**
     * Approach:
     */

    public int jump(int[] nums) {
        if(nums == null || nums.length < 2)
            return 0;
        
        int jumps = 1;
        int nextLevel = nums[0];
        int currLevel = nums[0];
        
        for(int i = 1; i<nums.length-1; i++) {
            nextLevel = Math.max(nextLevel, nums[i] + i);
         
            if(i < nums.length-1 && i == currLevel) {
                currLevel = nextLevel;
                jumps++;
            }
        }
        
        return jumps;
    }
}