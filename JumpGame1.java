//TC-O(n)
//SC-O(1)
class Solution {
    public boolean canJump(int[] nums) {
        int target = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] + i >= target){
                target = i;
             }            
        }
        return target == 0;
    }
}
