package Greedy1;
//Time complexity : O(n)
//Space complexity: O(1)
public class JumpGame2 {
    public int jump(int[] nums) {
        int count = 1;
        int nextJump = nums[0];
        int currInt = nums[0];
        if(nums.length == 1)
            return 0;
        for(int i=1; i<nums.length-1; i++){
            nextJump = Math.max(i+nums[i], nextJump);

            if(currInt == i){
                count++;
                currInt = nextJump;
            }
        }
        return count;
    }
}
