// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return true;
        int end = nums.length-1;
        for(int i = end-1 ; i >= 0 ; i--){
            if(i + nums[i] >= end) end = i;
        }
        return end == 0;
    }
}
