// Time Complexity: O(n) — Each index is visited once.
// Space Complexity: O(1) — Only a few integer variables used.
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        if (n == 1) return 0; // Already at the end, no jump needed

        int maxInt = nums[0];     // Farthest index we can reach
        int currInt = nums[0];    // End of current jump range
        int jumps = 1;            // We start with one jump (from index 0)

        for (int i = 1; i < n; i++) {
            // Update farthest reachable index
            maxInt = Math.max(maxInt, i + nums[i]);

            // If we reach the end of the current jump range
            if (i != n - 1 && i == currInt) {
                jumps++;          // Make another jump
                currInt = maxInt; // Update current range
            }
        }

        return jumps;
    }
}
