package Greedy-1;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

public class Problem1 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;
        int target = n - 1;
        for(int i = n -2; i >=0; i--){
            if(nums[i] + i >= target){
                target = i;
            }
        }
        return target == 0;
    }
}
