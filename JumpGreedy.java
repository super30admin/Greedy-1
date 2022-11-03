class Solution {
    //tc -o(n) sc-o(1)
    public boolean canJump(int[] nums) {
        if(nums.length < 2) return true;
        int target = nums.length-1;
        for(int i = nums.length-2; i>=0;i--)
        {
            if(nums[i] + i >= target) 
            target = i;
        }
        if(target == 0) return true;
        return false;
}
}