//Greedy-1

// Problem1 Jump Game (https://leetcode.com/problems/jump-game/)
// Timee - O(n)
// Space - O(1)
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0)
            return true;
        int max = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(max >= n - 1 || i > max)
                break;
            max = Math.max(max, i + nums[i]);
        }
        
        return max >= n - 1;
    }
}