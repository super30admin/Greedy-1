class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;

        int n = nums.length;

        int target = n - 1;

        for(int i = n-2; i >= 0; i--){

            if(i + nums[i] >= target){

                target = i;

            }

        }

        return target == 0;
    }
}