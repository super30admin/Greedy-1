// Time Complexity : O(k * n) 
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int superEggDrop(int k, int n) {
       
       int dp[]=new int[k+1], m;
       for(m=0;dp[k] < n; m++){
            
            for(int x=k;x>0;x--){
                dp[x]+=1+dp[x-1];
            }
       }
       return m;
    }
}