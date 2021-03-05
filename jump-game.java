class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==0)
            return false;
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            max--;
            if(max<0)
                return false;
            if(max<nums[i]){
                max = nums[i];
            }
        }
        return true;
    }
}

//Time complexity : O(N)
//Space complexity : O(1)
