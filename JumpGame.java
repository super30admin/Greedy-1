class Solution {
    public boolean canJump(int[] nums) {
        int i = nums.length - 1;
        for(int j = i-1; j >= 0; j--){
            if(nums[j] + j >= i){
                i = j;
            }
        }
        return (i == 0);
    }
}
