public class JumpGame2_BFS_Optmized {
    public int jump(int[] nums) {
        if(nums.length<2) return 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        int n = nums.length-1;
        int jumps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k=0;k<size;k++){
                int i = q.poll();
                for(int j=1;j<=nums[i];j++){
                    int newIdx = i+j;
                    if(newIdx>=n) return jumps;
                    if(!set.contains(newIdx)){
                        q.add(newIdx);
                        set.add(newIdx);
                    }
                }
            }
            jumps++;
        }
        return 0;
    }
}

// Time Complexity - O(n*k)
// Space Complexity - O(n)

public class JumpGame2_DFS_BruteForce {
    int min;
    public int jump(int[] nums) {
        min = Integer.MAX_VALUE;
        if(nums.length<2) return 0;
        dfs(nums,0,0);
        return min;
    }
    private void dfs(int[] nums, int idx, int jumps){
        // base
        if(idx>=nums.length-1){
            min = Math.min(min,jumps);
            return;
        }
        
        // logic
        for(int j=1;j<=nums[idx];j++){
            int newIdx = idx+j;
            dfs(nums,newIdx,jumps+1);
        }
    }
}

// Time Complexity - O(n*k)
// Space Complexity - O(n)


public class JumpGame2_Greedy {
    public int jump(int[] nums) {
        if(nums.length<2) return 0;
        int currInt = nums[0];
        int nextInt = nums[0];
        int jumps=1;
        for(int i=1;i<nums.length;i++){
            nextInt = Math.max(nextInt, i+nums[i]);
            if(i==currInt && i!=nums.length-1){
                jumps++;
                currInt = nextInt;
            }
        }
        return jumps;
    }
}

// Time Complexity - O(n)
// Space Complexity - O(1)