    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/jump-game-ii/       
    Time Complexity for operators : o(3n) .. n is the length of the nums array
    Extra Space Complexity for operators : o(1) 
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) 
    */ 

class Solution {
    public int jump(int[] nums) {
        
        // no need of base condition check as constrainsts said array has data
        if(nums.length == 1)
            return 0;
            
        int currInterval = nums[0];
        int nextInterval = nums[0];
        
        int jump = 1;
        
        for(int x = 1; x<nums.length; x++){
            nextInterval = (x + nums[x] > nextInterval) ? (x + nums[x]) : nextInterval;
            
            if(x == currInterval && x != nums.length-1){
                jump += 1;
                currInterval = nextInterval;
            }
            
            if(currInterval >= nums.length-1){
                return jump;
            }
        }
        return jump;
    }
}