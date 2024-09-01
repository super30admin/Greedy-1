//many sols for this ques - see 8/28 vid: bfs with visited set, top-down dfs with dp set/array
//greedy bottom up
//time: O(n)
//space: O(1)

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        int target = n - 1;
        for(int i = n - 2; i >= 0; i--) {
            if(i + nums[i] >= target) {
                target = i;
            }
        }
        return target == 0; // this means if target == 0, then return true, else return false
    }
};


//dp (not sure if optimal dp)
//time: O(n2)
//space: O(n)
/*
class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        if(n == 1) return true;
        if(nums[0] == 0) return false;
        vector<bool> dp(n, false);
        dp[0] = true;
        for(int i = 0; i < n-1; i++) {
            if(nums[i] != 0 && dp[i] == true) {
                int curr = i+1;
                while(curr < n && curr <= (i + nums[i])) {
                    dp[curr] = true;
                    curr++;
                }
            }
        }
        return dp[n-1];
    }
};
*/
// my earlier soln - O(n), O(1)
/*
class Solution {
public:
    bool canJump(vector<int>& nums) {
        // when first index is the last index (no need to jump)
        if(nums.size() == 1) {
            return true;
        }
        // we cannot jump anywhere if the first index itself is 0
        if(nums[0] == 0) {
            return false;
        }
        int i = nums.size() - 2;
        while(i >= 0) {
            if(nums[i] == 0) {
                int count = 0;
                i--;
                while(i >= 0 && nums[i] - count <= 1) {
                    count++;
                    i--;
                }
                // if we did not find any element capable of jumping over 0
                if(i == -1) {
                    return false;
                }
            }
            else {
                i--;
            }
        }
        return true;
    }
};
*/