//https://leetcode.com/problems/jump-game-ii/
// Time Complexity :O(n)  
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        if(n<2) return 0; //0 jumps are needed
        int currInt=nums[0];
        int nextInt=nums[0];
        int jumps=1;
        for(int i=1;i<n;i++)
        {
            nextInt=Math.max(nextInt,i+nums[i]); //5
            if(i!=n-1 && i==currInt)
            {
                jumps++;
                currInt=nextInt;
            }
        }
        return jumps;
    }
}