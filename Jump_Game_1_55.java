//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

class Jump_Game_1_55 {
    public boolean canJump(int[] nums) {
        int n = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--)
        {
            if(nums[i] + i >= n)
                n = i;
        }
        return n == 0;
    }
}
