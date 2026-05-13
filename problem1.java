import java.util.*;

class Solution {

    /**
    Time Complexity : O(N)
    Explanation:
    We traverse the array once while tracking the farthest reachable index.

    Space Complexity : O(1)
    Explanation:
    Only a few variables are used.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially confused about when to detect that we are stuck.
    Fixed it by tracking:
        - currInt → current reachable boundary
        - nextInt → farthest reachable index from current range
    If currInt and nextInt become same, it means we cannot move forward.
    */

    public boolean canJump(int[] nums) {

        int n = nums.length;

        if (n == 1) return true;

        int currInt = nums[0];
        int nextInt = nums[0];

        if (currInt >= n - 1) return true;

        for (int i = 0; i < n; i++) {

            // Update farthest reachable index
            nextInt = Math.max(nextInt, i + nums[i]);

            // Reached current boundary
            if (i == currInt && currInt != n - 1) {

                // Cannot move further
                if (currInt == nextInt) return false;

                currInt = nextInt;

                if (currInt >= n - 1) return true;
            }
        }

        return true;
    }
}