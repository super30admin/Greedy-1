// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int currentInterval = nums[0];
        int nextInterval = nums[0];
        int jump = 1;
        for(int i =  1; i < nums.length ; i++){
            nextInterval = Math.max(nextInterval,i+nums[i]);
            if(i == currentInterval && i < nums.length-1){
                currentInterval = nextInterval;
                jump++;    
            }
        }
        return jump;
    }
}
