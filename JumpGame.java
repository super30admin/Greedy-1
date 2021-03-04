// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Use a greedy algorithm to fetch the maximum jumps that can be made in a given interval, then reset that interval to that maximum jump number and then repeat till the last element is not reached.

public class JumpGame {
    // Solution 1 : Linear
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        
        int len = nums[0];
        int i = 1;
        int jump = 0;
        
        while(i <= len && i < nums.length){
            if(i + nums[i] >= nums.length - 1){
                return true;
            }
            
            if(i + nums[i] > jump){
                jump = i + nums[i];
            }
            
            if(i == len){
                i = len;
                len = jump;
                jump = 0;
            }
            
            i++;
        }
        
        return false;
    }

    // Solution 2 : Recursive
    // public boolean canJump(int[] nums) {
        
    //     return helper(nums, 0);
    // }
    
    // private boolean helper(int[] nums, int index){
    //     if(index >= nums.length - 1){
    //         return true;
    //     }
        
    //     for(int i = 1; i <= nums[index]; i++){
    //         if(helper(nums, i + index))
    //             return true;
    //     }
        
    //     return false;
    // }
}
