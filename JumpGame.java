//TC: O(n)
//SC: O(1)
//approach: reverse iteration to see if we can reach this index from net/left and so on

public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int target = nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(i+nums[i]>=target){
                target = i;
            }
        }
        return target==0;
    }
}
