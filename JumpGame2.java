// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The brute force way of solving it is to find all possible combinations of jumping positions using top down
recursive DP and backtrack. However, to optimize the TC from O(n^2), we greedily solve by trying to understand
the farthest reachable index from current index that we can jump first and then see if we can finish the starting
range of the current jump, then we direcly jump to the start point of the next jump instead of taking the window
from current starting range to next end range.
 */
class Solution {
    public int jump(int[] nums) {
        int n = nums.length , ans = 0;
        //starting range of the 1st jump is [0,0]
        int currEnd = 0, currFar = 0;

        for(int i = 0 ; i < n - 1 ; i++) {
            //update the farthest reachable index u can jump
            currFar = Math.max(currFar, i + nums[i]);

            //if we finish the starting range of this jump, then proceed to the start point of next jump
            if(i == currEnd) {
                currEnd = currFar;
                ans++;
            }
        }
        return ans;
    }
}