// Time Complexity : O(n) --> where n is the length of input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (45): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int jump(int[] nums) {
        // edge case
        if (nums == null || nums.length < 2) return 0;
        
        int jumps = 1;
        int currInterval = nums[0];
        int nextInterval = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            nextInterval = Math.max(nextInterval, i + nums[i]);
            if (i < nums.length - 1 && i == currInterval) {
                currInterval = nextInterval;
                jumps++;
            }
        }
        return jumps;
    }
}