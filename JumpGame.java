// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes


public class JumpGame {
    public boolean canJump(int[] nums) {
        int goal = nums.length-1;

        for(int i=nums.length-2; i>=0; i--){
            if(i+nums[i] >= goal){
                goal=i;
            }
        }
        return goal==0;
    }
}
