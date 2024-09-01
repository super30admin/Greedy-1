// 8/28 vid
//greedy
//time: O(n)
//space: O(1)

class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        if(n == 1) return 0;
        int jumps = 1;
        int currInterval = nums[0];
        int nextInterval = nums[0];
        for(int i = 0; i < n; i++) {
            nextInterval = max(nextInterval, i + nums[i]);
            if(i == currInterval) {
                if(i != n-1) {
                    jumps++;
                }
                currInterval = nextInterval;
            }
        }
        return jumps;
    }
};

//dp
//time: O(n2)
//space: O(n)
/*
class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        if(n == 1) return 0;
        vector<int> dp(n, 0);
        for(int i = n-2; i >= 0; i--) {
            if(nums[i] != 0) {
                int ans = 10000;
                for(int curr = i+1; curr<=(i+nums[i]) && curr<n; curr++) {
                    if(nums[curr]!=0 || (nums[curr] == 0 && curr == (n-1)))
                    ans = min(ans, dp[curr]);
                }
                dp[i] = ans+1;
            }
        }
        return dp[0];
    }
};
*/