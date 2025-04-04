// Problem2 Jump Game II (https://leetcode.com/problems/jump-game-ii/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take 2 variables named currentInterval and nextInterval and jumps as 1. Iterate through the nums array and when i is greater than
 * currInterval make currInterval as nextInterval and increase jump, in all other cases take nextInterval as max(nextInterval, i+nums[i]).
 * Finally return jumps.
 */
class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2) return 0;
        int currInterval = nums[0];
        int nextInterval = nums[0];
        int jumps = 1;
        for(int i = 0; i < nums.length; i++){
            if(i > currInterval){
                currInterval = nextInterval;
                jumps++;
            }
            nextInterval = Math.max(nextInterval, i+nums[i]);
        } 
        return jumps;
    }
}