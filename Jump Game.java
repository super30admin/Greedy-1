// Time Complexity : O(n)
// Space Complexity : O(1)

class JumpGame {
    public boolean canJump(int[] nums) {
        int lastGoodIndex = nums.length - 1;
        for(int i = nums.length - 1; i >=0; i--){
            if(nums[i] + i >= lastGoodIndex){
                lastGoodIndex = i;
            }
        }

        return lastGoodIndex == 0;
    }
}