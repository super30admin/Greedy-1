//Time - O(n)
//Space - O(1)
class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length<2)
            return true;
        int dest = nums[nums.length-1];
        for(int i=nums.length-1;i>=0;i--){
            if(i+nums[i]>=dest)
                dest = i;
        }
        return (dest==0);
    }
}
