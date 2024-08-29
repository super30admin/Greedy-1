// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class JumpGame {
    // using greedy on intervals
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int target = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= target) {
                target = i;
            }
        }
        return target == 0;
    }
}

class JumpGame {
    // using greedy from the start of the array
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n < 2) return true;
        int currInterval = nums[0];
        int nextInterval = nums[0];
        for(int i = 0; i < n; i++){
            nextInterval = Math.max(nextInterval, i + nums[i]);
            if(i == currInterval && currInterval == nextInterval && i != nums.length - 1) return false;
            if(i != nums.length - 1 && nextInterval>= nums.length - 1) return true;
            if(currInterval == i){
                currInterval = nextInterval;
            }
        }
        if(nextInterval >= nums.length - 1) return true;
        return false;
    }
}