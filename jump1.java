// Time Complexity: O(n) — single right-to-left pass.
// Space Complexity: O(1) — constant extra space.

// Initialize target = last index (n-1).
// Scan i from n-2 down to 0; if i + nums[i] ≥ target, move target to i.
// Return target == 0 (start can reach the last index if target collapses to 0).

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;

        int target = n - 1;

        for(int i = n - 2; i >= 0; i--){
            if(nums[i] + i >= target){
                target = i;
            }
        }

        return target == 0;
    }
}
