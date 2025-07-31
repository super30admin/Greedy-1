// Time Complexity : O(n)
// Space Complexity : O(1)
class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        if (n < 2) {
            return true; // Already at the last index
        }

        int maxReach = 0; // Tracks the farthest index you can reach

        for (int i = 0; i < n; ++i) {
            if (i > maxReach) {
                return false; // Can't reach this position
            }

            // Update the farthest index reachable so far
            maxReach = max(maxReach, i + nums[i]);

            // Early exit if you can reach or exceed the last index
            if (maxReach >= n - 1)
                return true;
        }

        return false; // Redundant, just for completeness
    }
};
