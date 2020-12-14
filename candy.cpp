class Solution {
public:
    int candy(vector<int>& ratings) {
        vector<int> dp(ratings.size(),1);
        
        for (int i=1;i<dp.size();i++) {
            if (ratings[i]>ratings[i-1]) {
                dp[i]=dp[i-1]+1;
            }
        }   
        int sum=dp[ratings.size()-1];
        for (int i=ratings.size()-2;i>=0;i--) {
            if (ratings[i]>ratings[i+1]) {
                dp[i]=max(dp[i+1]+1,dp[i]);
            }
            sum+=dp[i];
        }

        // for (auto x:dp) {
        //    // cout<<x<<" ";
        //     sum+=x;
        // }
        return sum;
    }
};