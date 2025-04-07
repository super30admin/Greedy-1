// Time Complexity: O(n)
// Space Complexity: O(1)
// Did you run the code on LeetCode? Yes

// Approach:
// 1. Start from the last index and move backwards to the first index.
// 2. For each index, check if you can reach the goal (last index) from that index.
// 3. If you can reach the goal from the current index, update the goal to the current index.


class Solution {
    public:
        bool canJump(vector<int>& nums) {
            int goal = nums.size() - 1;
            for(int i = nums.size() - 1; i >= 0; i--){
                if(i + nums[i] >= goal){
                    goal = i;
                }
            }
            return goal == 0;
        }
    };