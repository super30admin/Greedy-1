/*
    LC - 55. Jump Game
    TC - O(n)
    SC - O(1) 
*/

class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) {
            return true;
        }
        int destination = nums.length - 1;
        int n = nums.length;
        for(int i = n - 2; i >=0; i--) {
            if(nums[i] + i >= destination) {
                destination = i;
            }
        }
        return destination == 0;
    }
}