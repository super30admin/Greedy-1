class Solution {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            if(i>max)
                return false;
            max = Math.max(max, i+nums[i]);
            if(max>=nums.length)
                return true;
        }
        return true;
    }
}