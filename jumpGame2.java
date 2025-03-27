// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class jumpGame2 {
    class Solution {

        public int jump(int[] nums) {
            int jumps = 0;
            int l = 0;
            int r = 0;

            for (int i = 0; i < nums.length - 1; i++) {
                r = Math.max(r, i + nums[i]);
                if (i == l) {
                    jumps++;
                    l = r;
                }
            }
            return jumps;
        }
    }
}
