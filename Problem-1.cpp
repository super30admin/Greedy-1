55. Jump Game

TC O(n)
SC O(1)

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int target = nums.size()-1;
        for (int i= nums.size()-2; i>=0; i--) {
            if (nums[i] + i >= target) {
                target = i;
            }
        }
        return (target == 0);
    }
};
