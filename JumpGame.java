// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            //corner case
            if(nums == null || n == 0) return false;
            if(n == 1) return true;

            //logic - Greedy Approach
            int curr = n-1;
            int prev = n-1;
            boolean result = false;

            for(int i = n-2; i>=0; i--) {
                prev = i;
                if(prev + nums[prev] >= curr) {
                    result = true;
                } else {
                    result = false;
                }
                if(result)
                    curr = prev;
            }

            return result;
        }
    }
}
