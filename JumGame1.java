// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// we can do bfs, dfs, DP, but greedy is optimal 
// we start from the end and check if we can reach the end from the current index,
//  if yes then we update the target to the current index,
//  at the end if the target is 0 then we can reach the end from the start
// we can also start from the start and keep track of the maximum reach at each index,
//  if we reach the end then we can return true, if we reach the end of the array and we haven't reached the end then we can return false


class Solution {

    public boolean canJump(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return true;
        }

        int target = n - 1;

        for (int i = n - 2; i >= 0; i--) {

            if (i + nums[i] >= target) {
                target = i;
            }
        }

        return target == 0;
    }
}