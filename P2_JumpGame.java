// TC: O(n)
// SC: O(1)
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n < 2) return true;
        int required = 1;
        int i = n-2;
        while(i >= 0) {
            if(nums[i] >= required) {
                required = 1;
            } else {
                required += 1;
            }
            i--;
        }
        
        if(nums[0] >= required) {
            return true;
        }
        return false;
    }
}