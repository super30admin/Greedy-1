public class JumpGame {
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public boolean canJump(int[] nums){

        int lastPos = nums.length-1;
        for(int i =nums.length - 1; i>=0; i--){

            if(i+ nums[i] >= lastPos){
                lastPos = i;
            }
        }

        return lastPos == 0;
    }
    //Time Complexity:O(N2)
    //Space Complexity:O(N)
    public boolean canJumpBottomUp(int[] nums) {

        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;

        for(int i = nums.length - 2; i >=0; i--){

            for(int j = 1; j <= nums[i] && i + j < nums.length; j++){
                if(dp[i+j] == true){
                    dp[i] = true;
                }
            }
        }

        return dp[0];

    }
    //Time complexity: O(N2)
    //Space Complexity: O(N)
    int[] memo;
    public boolean canJumpMemoRecurse(int[] nums) {
        memo = new int[nums.length];
        return helper(nums, 0);
    }

    private boolean helper(int[] nums, int idx){

        if(idx >= nums.length){
            return false;
        }
        if(memo[idx] != 0) return memo[idx] == 1?true:false;

        if(idx == nums.length - 1) return true;

        boolean isPossible = false;
        for(int i = 1; i<= nums[idx]; i++){
            isPossible = isPossible || helper(nums, idx+i);
        }
        memo[idx] = isPossible == true? 1: -1;
        return isPossible;
    }
}
