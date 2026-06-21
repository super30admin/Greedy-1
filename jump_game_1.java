// Time Complexity : O(n) because we scan the array once from right to left
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We work backwards and keep track of the leftmost position that can reach the end.
// If the current index can reach the target, we move the target to this index.
// At the end, if the target becomes 0, the first index can reach the last index.

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        if(n == 1) return true;

        // last position we need to reach
        int target = n - 1;

        for(int i = n - 2; i >= 0; i--) {

            // current index can reach target
            if(nums[i] + i >= target) {
                target = i;
            }
        }

        return target == 0;
    }
}