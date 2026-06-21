// Time Complexity : O(n) because we scan the array once
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We greedily track the current jump range and the farthest position reachable within that range.
// When we reach the end of the current range, we must take a jump and extend the range to the farthest reachable index.
// This guarantees the minimum number of jumps because we always maximize reach at each jump.

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        if(n == 1) return 0;

        int currInt = nums[0];
        int maxInt = nums[0];
        int jumps = 1;

        for(int i = 1; i < n; i++) {

            // farthest reachable in current window
            maxInt = Math.max(maxInt, nums[i] + i);

            // end of current jump range
            if(i == currInt && i != n - 1) {
                jumps++;
                currInt = maxInt;
            }
        }

        return jumps;
    }
}