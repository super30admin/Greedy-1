// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class JumpGameII {
    class Solution {
        public int jump(int[] nums) {
            int n = nums.length;
            if(n < 2) return 0;
            int currInterval = nums[0];
            int nextInterval = nums[0];
            int jumps = 1;
            for(int i=1; i<n; i++) {
                nextInterval = Math.max(nextInterval, nums[i] + i);

                if(i != n-1 && i == currInterval) {
                    currInterval = nextInterval;
                    jumps+=1;
                }
            }
            return jumps;
        }
    }
}
