//TIme Complexity : O(n) n is the numberof elements in nums
//Space Complexity : O(1)
// LeetCode : passed all tests.

class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length <2) return true;
        int n = nums.length;
        int goal = n-1;
        for(int i = n-2;i>=0;i--){
            if(i+nums[i]>=goal) {
                goal = i;
            }
            
        }
        if(goal == 0) return true;
        return false;
    }
}