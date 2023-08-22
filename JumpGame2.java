import java.util.Arrays;

public class JumpGame2 {

    //Time Complexity = O(N)
    //Space complexity:O(1)
    public int jump(int[] nums) {
        // The starting range of the first jump is [0, 0]
        int answer = 0, n = nums.length;
        int curEnd = 0, curFar = 0;

        for (int i = 0; i < n - 1; ++i) {
            curFar = Math.max(curFar, i + nums[i]);

            if (i == curEnd) {
                answer++;
                curEnd = curFar;
            }
        }

        return answer;
    }
    //Time Complexity: O(N2)
    //Space Complexity: O(N)
    public int jumpDp(int[] nums){
        int[] dp = new int[nums.length];

        for(int i = nums.length - 2; i >=0; i--){
            int min = 9999;
            for(int j = 1; j<= nums[i] && i +j < nums.length; j++){
                min = Math.min(min, dp[i+j]);
            }
            dp[i] = min+1;
        }

        return dp[0];
    }

    int[] memo;
    //Time Complexity: O(N2)
    //Space Complexity: O(N)
    public int jumprecursion(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int min = helper(nums, 0);

        return min;
    }

    private int helper(int[] nums, int idx){
        if(idx >= nums.length){
            return 9999;
        }
        if(memo[idx]!= -1) return memo[idx];

        if(idx == nums.length - 1){
            return 0;
        }

        int minJump = 9999;
        for(int j = 1; j<= nums[idx];j++){
            minJump = Math.min(minJump, (helper(nums, idx+j)+1));
        }

        memo[idx] = minJump;

        return minJump;
    }
}
