// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// we can do bfs, dfs, DP, but greedy is optimal
// we start from the start and keep track of the maximum reach at each index,
//  if we reach the end then we can return the number of jumps, 
// if we reach the end of the array and we haven't reached the end then we can return -1 
// we also keep track of the current end of the jump,
//  if we reach the current end then we need to jump and update the current end to the maximum reach  
// we can also start from the end and check if we can reach the end from the current index,
//  if yes then we update the target to the current index,
//  at the end if the target is 0 then we can reach the end from the start, we can also keep track of the number of jumps needed to reach the end from the current

class Solution {

    public int jump(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        int maxReach = nums[0];
        int currentEnd = nums[0];
        int jumps = 1;

        for (int i = 1; i < n; i++) {

            maxReach = Math.max(maxReach, i + nums[i]);

            if (i != n - 1 && i == currentEnd) {
                jumps++;
                currentEnd = maxReach;
            }
        }

        return jumps;
    }
}