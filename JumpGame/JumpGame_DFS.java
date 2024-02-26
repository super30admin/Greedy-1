/* Time Complexity : O(n*max)) 
 *  n - length of input array - nums 
 *  max - the max value in nums as the internal for loop would run that many times at the maximum */
/* Space Complexity : O(2n) ~ O(n) 
 *  size taken by the recursive stack and dp array */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//DFS

class Solution {
    int[] dp; 
    //0 - not visited yet
    //1 - visited and not able to reach last idx
    //2 - visted and able to reach last index
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;
        this.dp = new int[n];
        return dfs(nums, 0);
    }

    private boolean dfs(int[] nums, int idx){
        //base condn
        if(dp[idx] != 0){
            if(dp[idx] == 1) return false;
            else return true;
        }
        if(idx == nums.length - 1){
            dp[idx] = 2;
            return true;
        } 
        //logic
        for(int i  = 1; i <= nums[idx]; i++){
            int child = idx + i;
            if(dfs(nums, child)){
                dp[idx] = 2;
                return true;
            }
        }
        dp[idx] = 1;
        return false;
    }
}