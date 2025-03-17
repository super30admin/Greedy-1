// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Jump Game
// Approach: Greedy
// Time Complexity: O(n)
// Space Complexity: O(1)


class Solution {
public:
    bool canJump(vector<int>& nums) {
        if (nums.empty() || nums.size() == 1) {
            return true;
        }
        int n = nums.size();
        int destination = n - 1;
        
        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= destination) {
                destination = i;
            }
        }
        return destination == 0;
    }
};