// Problem1 Jump Game (https://leetcode.com/problems/jump-game/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, since our target is reaching the last index, just start from last index and try to move towards the 0th index. if i+nums[i]==target,
 * target=i. Finally return id target is 0.
 */
class Solution {
    public boolean canJump(int[] nums) {
        int target = nums.length-1;
        for(int i = nums.length-1; i>=0; i--){
            if(i + nums[i] >= target){
                target = i;
            }
        }
        return target == 0;
    }
}
