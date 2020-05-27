// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class JumpGame {
    public boolean canJump(int[] nums) {
        int lastGoodIndex = nums.length - 1;
        for(int i = nums.length - 1; i >=0; i--){
            if(nums[i] + i >= lastGoodIndex){
                lastGoodIndex = i;
            }
        }

        return lastGoodIndex == 0;
    }
}
