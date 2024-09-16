// Time Complexity : O(n2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No, few test cases failing
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]==0){
                dp[i]=Integer.MAX_VALUE;
            }
            else {
                if(i==nums.length-1){
                    dp[i]=0;
                }
                else {
                    int maxJumpSteps = nums[i];
                    int minNoOfJumps = Integer.MAX_VALUE;
                    
                    for(int j=i+1;i+maxJumpSteps>j;j++){
                        if(nums[j]!=0){
                            int numJumps = dp[j]+1;
                            if(numJumps<minNoOfJumps){
                                minNoOfJumps = numJumps;
                            }    
                        }
                    }
                    dp[i]=minNoOfJumps;    
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}
