// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The brute force way is to recursively jump each position and check if we are able to reach the array end and
backtrack accordingly. It can be solved using top down DP with TC of O(n^2), but the optimal improvement is
to greedily check by starting from the end of the array and verify if the current position and the index's value
sum is greater than the last seen position which is initially the last index of the array.If so, we are jumping
backwards and update the last seen position, Finally if the last position reaches start index of the array, we
return true, if not false.
 */
class Solution {
    public boolean canJump(int[] nums) {
         int lastPos = nums.length - 1;
         for(int i = nums.length - 1 ; i >= 0 ; i--) {
             if(i + nums[i] >= lastPos)
                 lastPos = i;
         }

         return lastPos == 0;
}