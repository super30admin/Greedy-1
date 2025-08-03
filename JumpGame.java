// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Start from back. For each element in array, if we can reach target = n-1, update target to current index.
/// At the end if target is 0, then we can jump else no
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int target = n-1;
        for(int j=n-2;j>=0;j--){
            if(j+nums[j]>=target){
                target = j;
            }
        }
        return target == 0;
    }
}