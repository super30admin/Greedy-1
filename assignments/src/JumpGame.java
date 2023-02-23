// Approach: Greedy - fastest: Iterate the array from back, starting from 2nd last index
// If index + nums[index] >= target, target = last index, change the target,
// new target = current index i
// Finally return if target = 0
// Time: O(n)
// Space: O(1)

class JumpGame {
    public boolean canJump(int[] nums) {
        int target = nums.length - 1;

        for (int i = nums.length-2; i >= 0; i--) {
            if (i + nums[i] >= target) {
                target = i;
            }
        }
        return target == 0;
    }
}