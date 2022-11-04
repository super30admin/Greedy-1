public class JumpGame_BruteForce_BFS {
    public boolean canJump(int[] nums) {
        if(nums.length<2) return true;
        int n = nums.length-1;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int i = q.poll();
            for(int j=1;j<=nums[i];j++){
                int newIdx = i+j;
                if(newIdx>=n) return true;
                q.add(newIdx);
            }
        }
        return false;
    }
}

// Time Complexity - O(n power k)
// Space Complexity - O(n)


public class JumpGame_Optimized_BFS {
    public boolean canJump(int[] nums) {
        if(nums.length<2) return true;
        int n = nums.length-1;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(0);
        while(!q.isEmpty()){
            int i = q.poll();
            for(int j=1;j<=nums[i];j++){
                int newIdx = i+j;
                if(newIdx>=n) return true;
                if(!set.contains(newIdx)){
                    q.add(newIdx);
                    set.add(newIdx);
                }
            }
        }
        return false;
    }
}

// Time Complexity - O(n power k)
// Space Complexity - O(n)


public class JumpGame_BruteForce_DFS {
    public boolean canJump(int[] nums) {
        if(nums.length<2) return true;
        return dfs(nums,0);
    }
    private boolean dfs(int[] nums, int idx){
        // base
        if(idx>=nums.length-1) return true;
        
        // logic
        int max = nums[idx];
        for(int j=1;j<=max;j++){
            int newIdx = idx+j;
            if(dfs(nums, newIdx)) return true;
        }
        return false;
    }
}

// Time Complexity - O(n power k)
// Space Complexity - O(n)


public class JumpGame_Memoization_DFS {
    int[] dp;
    public boolean canJump(int[] nums) {
        if(nums.length<2) return true;
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return dfs(nums,0);
    }
    private boolean dfs(int[] nums, int idx){
        // base
        if(idx>=nums.length-1) return true;
        if(dp[idx]==2) return false;
        // logic
        int max = nums[idx];
        dp[idx] = 1;
        for(int j=1;j<=max;j++){
            int newIdx = idx+j;
            if(newIdx>=nums.length-1) return true;
            if(dp[newIdx]==-1 && dfs(nums, newIdx)) return true;
        }
        dp[idx]=2;
        return false;
    }
}

// Time Complexity - O(n power k)
// Space Complexity - O(n)


public class JumpGame_Greedy {
    public boolean canJump(int[] nums) {
        if(nums.length<2) return true;
        int target = nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=target)
                target = i;
        }
        return target==0;
    }
}

// Time Complexity - O(n)
// Space Complexity - O(1)