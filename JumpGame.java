class Solution {
    public boolean canJump(int[] nums) {
        //initally target is last index
        int target = nums.length - 1;
        for(int i = nums.length - 2 ; i>=0 ; i--){
            if(i + nums[i] >= target){
                target = i;
            }
        }
        if(target == 0){
            return true;
        }
        else{
            return false;
        }
        
    }
}