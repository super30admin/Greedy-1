/* Time Complexity : O(n) 
 *  n - length of input array - nums */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Greedy

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int target = n - 1;
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] + i >= target){
                target = i;
            }
        }
        return target == 0;
    }
}