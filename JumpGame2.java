// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Use a greedy algorithm to fetch the maximum jumps that can be made in a given interval, then reset that interval to that maximum jump number, and keep counting the jumps while doing so.

public class JumpGame2 {
    // Solution 1 : Linear
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        
        int len = nums[0];
        int i = 1;
        int jump = 0;
        
        int res = 0;
        while(i <= len && i < nums.length){            
            if(i + nums[i] > jump){
                jump = i + nums[i];
            }
            
            if(i == len || i == nums.length - 1){
                i = len;
                len = jump;
                jump = 0;
                
                res = res + 1;
            }
            
            i++;
        }
        
        return res;
    }

    // Solution 2 : Recursive
    // int min = Integer.MAX_VALUE;
    // public int jump(int[] nums) {
    //     helper(nums, 0, 0);
    //     return min;
    // }
    
    // private void helper(int[] nums, int index, int jump){
    //     if(index >= nums.length - 1){
    //         min = Math.min(min , jump);
    //         return;
    //     }
        
    //     for(int i = 1; i <= nums[index]; i++){
    //         helper(nums, i + index, jump + 1);
    //     }
    // }
}
