import java.util.*;

public class JumpGame_2 {

    //BFS solution
    //TC : O(n^2)
    //SC : O(n)
    public int jump(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int jumps = 0;
        q.add(0);
        set.add(0);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (curr == nums.length - 1) return jumps;

                for (int j = 1; j <= nums[curr]; j++) {
                    if (curr + j == nums.length - 1) return jumps + 1;
                    if (!set.contains(curr + j)) {
                        q.add(curr + j);
                        set.add(curr + j);
                    }
                }
            }
            jumps++;
        }
        return -1;
    }

    //DFS with DP solution
    //TC: O(n^2)
    //SC: O(n)
    int[] dp;
    public int jump_dfs(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs_with_dp(nums, 0);
    }

    private int dfs_with_dp(int[] nums, int idx){

        //base
        if(idx >= nums.length - 1) return 0; //no jump required
        if(dp[idx] != -1) return dp[idx]; //return alreay explored value

        //logic
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= nums[idx];i++){
            int result = dfs_with_dp(nums, idx + i);
            min = Math.min(min, result);
        }
        if(min != Integer.MAX_VALUE){
            dp[idx] = min + 1; //add 1 to jump
        }else{
            dp[idx] = min; // mark as explored by setting inf
        }
        return dp[idx];
    }

}
