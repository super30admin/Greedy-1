// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to learn

/*
 * Problem# : 45 Jump Game II
 * Idea is to start with currentInterval i.e., nums[0] i.e., the maximum we can jump we can do standing at nums[0]
 * the maxIntrvl - is variable interval length based on the nums[i]+i, i.e., using the current jump what is the maximum we can reach
 * 
 * now while we iterate through the length of array, 
 * maxIntrvl would be Math.max(maxIntrvl, nums[i]+1)
 * 
 * and when currentIntrvl is equal to index in the for loop, we set our maxInterval to currentIntrvl and add a jump
 */

import java.util.*;

public class JumpII {

    public int jump(int[] nums) {
        if (nums.length <= 1)
            return 0;

        int currentIntrvl = nums[0];
        int maxIntrvl = nums[0];
        int jumps = 1;

        for (int i = 1; i < nums.length; i++) {
            maxIntrvl = Math.max(maxIntrvl, nums[i] + i);
            if (currentIntrvl < nums.length - 1 && currentIntrvl == i) {
                currentIntrvl = maxIntrvl;
                jumps++;
            }
        }

        return jumps;
    }

}
