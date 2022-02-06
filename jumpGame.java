// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// We traverse from the back and check at each index if we can reach the last slot.
// update the destination to i each time its reachable, finally if we reach destination as 0, we return true

class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length, destination = n-1;
        if (n == 1) return true;

        for (int i=n-2; i>=0; i--) {
            if (i+nums[i] >= destination) {
                destination = i;
            }
        }
        return destination==0;
    }
}