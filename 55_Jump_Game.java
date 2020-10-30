    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/jump-game/
    Time Complexity for operators : o(n) .. n is the length of the nums array
    Extra Space Complexity for operators : o(1) 
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Start from end that will reduct some calcualtios. Initially, destination will the end position.
                    B) now, check whether nums[x]+x >= destination if it is then change the destination to x.
                    C) At the end, check if destionatio == 0 if it is then we reached else not.
    */  

class Solution {
    public boolean canJump(int[] nums) {
        
        // no need to check base condition as nums will have valid numbers as per Constraints.
        
        int destination = nums.length - 1;
        
        for(int x = nums.length - 2; x>=0;x--){
            if(nums[x]+x >= destination){
                destination = x;
            }
        }
        return destination == 0;
    }
}