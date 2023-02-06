// Time Complexity: O(n)
// Space Complexity: O(1)

/*
 * traverse through the array from the back and try to reach the target
 * from that position and keep on moving the target when we can reach 
 * that position. if target reaches 0 return true.
 */

class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int n = nums.length;
        int target = n-1;
        for(int i = n-2; i >= 0; i--){
            if(nums[i]+i >= target) target = i;
        }
        if(target == 0) return true;
        return false;
    }
}