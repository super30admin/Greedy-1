// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Initialization: Start from the last position and set it as the destination.
//Backward Check: Iterate from the second last element to the first, updating the destination if the current position can reach or exceed it.
//Final Check: If the destination reaches the first index, return true; otherwise, return false

class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return true;
        }
        int destination = nums.length-1;
        int n = nums.length;
        for(int i = n - 2; i>= 0; i--){
            if(nums[i] + i >= destination){
                destination = i;
            }
        }
        return destination == 0;
    }
}