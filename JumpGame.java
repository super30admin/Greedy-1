// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Initialize target to last index
// Check if we can reach the target from the previous indexes
// If we can reach , change the target to that current index
// Finally we can check if the target reached the first index

class Solution {
    public boolean canJump(int[] nums) {
        int target = nums.length - 1;
        for (int i = target - 1; i >= 0; i--)
            if (i + nums[i] >= target)
                target = i;
        return target == 0;
    }
}