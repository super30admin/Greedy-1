Time Complexity = O(n)
Space Complexity = O(1)

class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int maxJump = 0, prev = 0, min = 0;
        int i = 0;
        while (prev - i + 1 > 0) {
            min++;
            for(i = 0; i <= prev; i++) {
                maxJump = Math.max(maxJump, nums[i] + i);
                if (maxJump >= nums.length - 1) return min;
            }
            prev = maxJump;
        }
        return 0;
    }
}