// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution


// Your code here along with comments explaining your approach
//the idea is to see what is the maximum I can reach in a particular level.

class Solution {
    public int jump(int[] nums) {
       
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 0;
        int jumps = 0, scope = 0, farthest = 0;
        
        for(int i=0; i< nums.length; i++){
            farthest = Math.max(farthest, i + nums[i]);
            if(farthest >= nums.length-1) return jumps + 1;
            if(i==scope){
                jumps++;
                scope = farthest;
            }
        }
        
        return jumps;
    }
}