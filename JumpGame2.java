//TC : O(n)
//SC : O(1)
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n < 2) return 0;
        int jumps = 0, currMaxJump = 0, maxJumpInWindow = 0;
        for (int i = 0; i < n - 1; i++) {
            maxJumpInWindow = Math.max(maxJumpInWindow, i + nums[i]);
            if (i == currMaxJump) {
                jumps++;
                currMaxJump = maxJumpInWindow;
                if(currMaxJump >= n) break;
            }
        }
        return jumps;
    }
}
