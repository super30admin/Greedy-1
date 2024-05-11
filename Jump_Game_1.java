//TC:O(n)
//SC:O(1)
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length < 2) {
            return true;
        }
        int currentInterval = nums[0];
        int nextInterval = nums[0];
        if(nextInterval == 0) {
            return false;
        }
        for(int i =0; i<nums.length;i++) {
            nextInterval = Math.max(nextInterval, i+ nums[i]);
            if(i == currentInterval && nextInterval == currentInterval && i != nums.length-1) {
                return false;
            }
            if(i != nums.length-1 && nextInterval >= nums.length-1) {
                return true;
            }
            if(currentInterval == i) {
                currentInterval = nextInterval;
            }
        }
        if(nextInterval >= nums.length-1) {
            return true;
        }
        return false;
    }
}