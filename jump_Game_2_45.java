//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

class jump_Game_2_45 {
    public int jump(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return 0;
        int curr = nums[0];
        int next = nums[0];
        int jumps = 1;
        for(int i = 1; i < nums.length; i++)
        {
            next = Math.max(next, nums[i] + i);
            if(i < nums.length - 1 && i == curr)
            {
                curr = next;
                jumps++;
            }
        }
        return jumps;
    }
}
