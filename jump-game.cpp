// Using DFS
class Solution {
public:
    bool dfs(vector<int> nums, int index) {
        // base
        if(index == nums.size()-1) return true;
        // logic
        for(int i = 1; i <= nums[index]; i++) {
            if(dfs(nums, index+i)) return true;
        }
        return false;
    }
    bool canJump(vector<int>& nums) {
        if(nums.size() == 1) return true;
        return dfs(nums, 0);
    }
};

// Greedy: From the backside of the array
// Time Complexity: O(n) n = size of the nums vector 
// Space Complexity: O(1)
class Solution {
public:
    bool canJump(vector<int>& nums) {
        int destination = nums.size()-1;
        for(int i = nums.size()-2; i >= 0; i--) {
            if(nums[i]+i >= destination)
                destination = i;
        }
        return destination == 0;
    }
};

// Greedy: From the First index  of the array
// Time Complexity: O(n) n = size of nums vector
// Space Complexity: O(1)
class Solution {
public:
    bool canJump(vector<int>& nums) {
        int reachable = 0;
        for(int i = 0; i < nums.size()-1; i++) {
            if(i <= reachable)
                reachable = max(reachable, nums[i]+i);
        }
        return reachable >= nums.size()-1;
    }
};
