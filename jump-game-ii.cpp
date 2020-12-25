// Time Complexity: O(n) n = size of nums vector
// Space Complexity: O(1)
class Solution {
public:
    int jump(vector<int>& nums) {
        if(nums.size() == 1) return 0;
        int currInt = nums[0];
        int nextInt = nums[0];
        int jumps = 1;
        for(int i = 0; i < nums.size()-1; i++) {
            nextInt = max(nextInt, nums[i]+i);
            if(currInt == i) {
                currInt = nextInt;
                jumps++;
            }
        }
        return jumps;
    }
};
