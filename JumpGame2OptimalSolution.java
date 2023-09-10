// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class JumpGame2OptimalSolution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int currInt = nums[0];
        int nextInt = nums[0];
        int jumps = 1;
        for(int i=1; i<= nums.length-2; i++){
            nextInt = Math.max(nextInt, i+nums[i]);
            if(currInt == i){
                currInt = nextInt;
                jumps++;
            }
        }

        return jumps;
    }
}
