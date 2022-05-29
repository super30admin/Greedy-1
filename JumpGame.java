// O(n) time: traverse nums array once
// O(1) space

class Solution {

    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--){
            if (i + nums[i] >= lastPos){
                lastPos = i; // update last position of where previous index needs to jump to
            }
        }
        return lastPos == 0;
    }
}