// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length; int ans;
        int[] cnt = new int[n];
        Arrays.fill(cnt,1);
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1])
                cnt[i] = cnt[i-1]+1;
        }
        ans = cnt[n-1];
        for(int i = n -2; i >=0 ; i--){
            if(ratings[i] > ratings[i+1])
                cnt[i] = Math.max(cnt[i],cnt[i+1]+1);
                ans += cnt[i];
        }
        return ans;
    }
}