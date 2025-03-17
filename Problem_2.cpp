// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Jump Game II 
// Approach: Greedy
// Time Complexity: O(n)
// Space Complexity: O(1)


class Solution {
public:
    int jump(vector<int>& nums) {
        if (nums.empty() || nums.size() == 1) {
            return 0;
        }
        int n = nums.size();
        int currInterval = nums[0];
        int nextInterval = nums[0];
        int jumps = 1;
        
        for (int i = 0; i < n; i++) {
            nextInterval = max(nextInterval, i + nums[i]);
            if (i < n - 1 && i == currInterval) {
                jumps++;
                currInterval = nextInterval;
            }
        }
        return jumps;
    }
};