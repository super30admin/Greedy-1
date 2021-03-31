// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int jump(int[] nums) {
        
        if(nums.length<2) return 0;
        int n = nums.length;
        int maxPos = nums[0];
        int maxSteps=nums[0];
        int jumps = 1;
        
        for(int i=1;i<n;i++) {
            
            int currJump = i+nums[i];
            if(maxSteps < i) {
                jumps++;
                maxSteps=maxPos;
            }
            maxPos=Math.max(maxPos,nums[i]+i);
            
        }
        return jumps;
    }
}
