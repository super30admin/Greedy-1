//Time = O(n), length of input array
//Space = O(n)

class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 0; // Maximum jump we can make from the current index
        for (int i = 0; i < nums.length; i++) {
            if (i > maxJump) { // If we cannot reach this index from previous indices, return false
                return false;
            }
            maxJump = Math.max(maxJump, i + nums[i]); // Update the maximum jump we can make from the current index
        }
        return true; // We can reach the last index
    }
}
