import java.util.*;

class Solution {

    /**
    Time Complexity : O(N)
    Explanation:
    We traverse the array once while maintaining the current reachable range
    and the farthest reachable index.

    Space Complexity : O(1)
    Explanation:
    Only a few variables are used.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially tried DP which worked but was O(N^2).
    Optimized it using greedy/BFS-level traversal idea:
        - currInt → current jump boundary
        - nextInt → farthest index reachable in current range
    Whenever we reach currInt,
    it means we must take another jump.
    */

    public int jump(int[] nums) {

        int n = nums.length;

        // Already at destination
        if (n == 1) return 0;

        int currInt = nums[0]; // current jump boundary
        int nextInt = nums[0]; // farthest reachable index

        int jumps = 1;

        for (int i = 1; i < n; i++) {

            // Update farthest reachable index
            nextInt = Math.max(nextInt, i + nums[i]);

            // Reached current boundary
            if (i == currInt && currInt != n - 1) {

                currInt = nextInt;
                jumps++;
            }
        }

        return jumps;
    }
}