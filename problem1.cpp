
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Approach 1: bottom up dp 
// Time Complexity : O(n^2)  (but this would work because overall it would be less than n^2 for large values)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        vector<int>dp(n,-1);// -1 for unknown, 0 for false, 1 for true
        dp[n-1] = true;
        for(int i = n-2;i>=0;i--)
        {
            int end = min(n-1,i+nums[i]);
            for(int j = i+1;j<=end;j++)
            {
                if(dp[j] == true){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0]==true;
    }
};

// Approach 2: Greedy 
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
 
 class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        int destination = n-1;
        for(int i = n-2;i>=0;i--)
        {
            if(i+nums[i]>=destination){
                destination = i;
            }
        }
        return destination == 0;
    }
};