// TC: O(n^2)
// SC: O(n)

// Approach: Bottom up dp: Check if you can reach
// any index which is valid (that can reach the last index)
// start from the back.

class JumpGame1 {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[dp.length - 1] = true;

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 1; j < nums.length && j <= nums[i]; j++) {
                if (dp[j + i]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }

    // TC: O(n)
    // SC: O(1)

    // Approach: start From the back; if current index + the value
    // can reach the target; then update the target; else keep going

    public boolean canJumpGreedy(int[] nums) {
        int target = nums.length - 1;
        boolean result = false;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= target) {
                result = true;
                target = i;
            } else {
                result = false;
            }
        }

        return result;
    }
}