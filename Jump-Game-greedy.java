// Time Complexity : O(N)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using Greedy, exlpore just 1 path from the last element till the first.
// If your able to reach the first index - true.

// 55. Jump Game

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int target = n-1;
        for(int i=n-2;i>=0;i--){
            if(i + nums[i] >= target){
                target = i;
            }
        }
        return target == 0;
    }
}