// Time Complexity : o(n)
// Space Complexity : 1
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 55

class Solution {
    public boolean canJump(int[] nums) {
        
        if(nums == null || nums.length < 2 ) return true;
        
        int destination = nums.length-1;
        for(int i = nums.length-2 ; i >= 0 ; i--){
            if(i + nums[i] >= destination ){
                destination = i ;
            }
        }
        return destination == 0;
    }
   
}