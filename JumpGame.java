/*
 * TC: O(n)
 * SC: O(1)
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int l = nums.length;
        int max = 0;
        for(int i = 0; i < l; i++) {
            // if we can't reach any index return false
            if(i > max) return false;
            //update the max range if necessary
            if(max < i + nums[i]) {
                max = i + nums[i];
            }
        }
        // we reached the last index, so return true
        return true;
    }
}
