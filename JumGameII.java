// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class JumpGamII {
    // Using Greedy from start of the array
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;
        int jumps = 1;
        int currInterval = nums[0];
        int nextInterval = nums[0];
        for (int i = 0; i < n; i++) {
            nextInterval = Math.max(nextInterval, i + nums[i]);
            // if i reaches to end of current interval
            if (i == currInterval) {
                // increase the jumps
                if (i != n - 1) {
                    jumps++;
                }
                // assign currentInterval to next Interval
                currInterval = nextInterval;
            }
        }
        return jumps;
    }
}