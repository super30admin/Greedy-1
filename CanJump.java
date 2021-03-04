// Time Complexity : The time complexity is O(n) where n is the length of the array
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public boolean canJump(int[] nums) {

        if(nums == null || nums.length < 2){
            return true;
        }

        int n = nums.length;
        int dest = n-1;

        for(int i = n-1;i>=0;i--){
            // cgeck if it is possible to reach the destination at every step
            if(dest <= i+nums[i]){
                dest = i;
            }
        }

        return dest == 0;
    }
}
