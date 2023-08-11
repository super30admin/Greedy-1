// Time: O(n)
// Space O(n)

class Solution {
    public boolean canJump(int[] nums) {
        int curIdx = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= curIdx) {
                curIdx = i;
                if (i <= 0) {
                    return true;
                }
            }
        }
        return curIdx <= 0;
    }
}