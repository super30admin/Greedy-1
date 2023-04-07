//Time Complexity : O(N)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * take steps as 0. Iterate from 0 to n-1. At each step, calculate max distance
 * it can jump and put it in end. Also maintain a current end variable to track
 * the current end position. When i reaches the current end position, increment
 * steps and update current end to the end which would be the next end that has
 * to be reached.
 *
 */
class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2) return 0;
       int currInterval = nums[0];
        int nextInterval = nums[0];
        int jumps = 1;
        for(int i=1;i<nums.length;i++){
            nextInterval = Math.max(nextInterval,nums[i]+i);
            if(i==currInterval && i!= nums.length-1){
                jumps++;
                currInterval = nextInterval;
            }   
        }
        return jumps;
    }
    
}
