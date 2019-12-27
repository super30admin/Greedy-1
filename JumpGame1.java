public class Solution {
    public boolean canJump(int[] nums) {
        int currpos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= currpos) {
                currpos = i;
            }
        }
        return currpos == 0;
    }
}
//SC:O(1)
//TC:O(n)
