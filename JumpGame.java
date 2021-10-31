package Greedy1;

//Time complexity : O(n)
//Space complexity: O(1)
public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxIdx = nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i] + i >= maxIdx){
                maxIdx = i;
            }
        }
        return maxIdx == 0;
    }
}
