// Time Complexity: Worst case O(n)
// Space Complexity: O(1)
// Idea here is to greedily choose the maximum length we can jump from each index
// if max jump from any index comes to be 0 we can not jump further
// as we are doing for each index it covers 1-n number we can jump
// if at any point we reach destination or overshoot, we can return true
class Solution {
    public boolean canJump(int[] nums) {
        int jump = 0;
        for(int i=0; i< nums.length; i++) {
            if(i>jump) return false;
            if(jump>=nums.length-1) return true;
            jump = Math.max(i+nums[i], jump);
        }
        return true;
    }
}