//Time Complexity-O(n^2)
//Space Complexity-O(n)
//Did the code execute on Leetcode? Yes

class Solution {
public:
    int jump(vector<int>& nums) {
        if(nums.size()==0 || nums.size()==1)
        {
            return 0;
        }
        vector<int>dp(nums.size(),INT_MAX);
        dp[0]=0;
        int a=0;
        for(int i=0;i<nums.size();i++)
        {
            int b=a+1;
            if(b<i+nums[i])
            {
                a+=i+nums[i]-b;
            }
            else
            {
                a+=0;
            }
            while(b<nums.size() && i+nums[i]>=b)
            {
                dp[b]=min(dp[i]+1,dp[b]);
                b++;
            }
            if(a>=nums.size())
            {
                break;
            }
        }
        return dp[nums.size()-1];
    }
};