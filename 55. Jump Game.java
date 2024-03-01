// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean canJump(int[] nums) {

        int n = nums.length-1;

        for(int i = n-1; i > -1; i--){
            if(nums[i] + i >= n){
                n = i;
            }
        }

        return n == 0;
        
    }
}
