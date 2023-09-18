// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * Start from n-1, and check if we can reach the target.
 * If we can reach the target, go to prev index and update the target adn check if we can reach that target.
 * Return if we can reach 0 from end.
 */

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int target = n-1;

        for(int i=n-2; i>=0; i--){
            if(nums[i] + i >= target){
                target = i;
            }
        }

        return target == 0;
    }
}