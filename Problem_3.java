//Time Complexity:O(n)
//Space Complexity:O(n)
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = 1; i < n; i++){
            if(ratings[i]>ratings[i-1]){
                dp[i]=dp[i-1]+1;
            }
        }
        for(int i = n-2; i >= 0; i--){
            if(ratings[i]>ratings[i+1]){
                if(dp[i]<=dp[i+1])
                    dp[i]=dp[i+1]+1;
            }
        }
        int sum = 0;
        for(int i :dp){
            sum+=i;
        }
        return sum;
    }
}