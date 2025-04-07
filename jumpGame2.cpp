// Time Complexity: O(n)
// Space Complexity: O(1)
// Did you run the code on LeetCode? Yes

// Approach:
// 1. Start from the first index and move to the last index.
// 2. For each index, calculate the maximum reachable index from that index.
// 3. If the current index is equal to the maximum reachable index, increment the jump count.
// 4. If the current index is greater than or equal to the last index, return the jump count.
// 6. If the current index is less than the last index, continue to the next index.
// 7. If the current index is less than the maximum reachable index, continue to the next index.
// 8. If the current index is greater than the maximum reachable index, return -1.

class Solution {
    public:
        int jump(vector<int>& nums) {
            if(nums.size() < 2){
                return 0;
            }
            int currMax = nums[0];
            int nextMax = nums[0];
            int jumps = 1;
            for(int i = 1; i < nums.size(); i++){
                nextMax = max(nextMax, i + nums[i]);
                if(currMax == i && i != nums.size() - 1){
                    currMax = nextMax;
                    jumps++;
                }
                if(currMax >= nums.size()){
                    break;
                }
            }
            return jumps;
        }
    };