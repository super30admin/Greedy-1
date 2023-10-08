/*
Time Complexity - O(n) where n is the number of elements in input array.
Space Complexity - O(1)
*/
class Solution {
    public boolean canJump(int[] nums) {
        int maxSteps = nums[0];
        for(int i = 1; i < nums.length; i++) {
            maxSteps--;
            if(maxSteps < 0)
                return false;
            maxSteps = Math.max(maxSteps, nums[i]);
        }
        return true;
    }
}
