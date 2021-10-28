// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int nextInterval = nums[0]; int currInterval = nums[0];
        int jumps = 1;
        
        for(int i=1; i <nums.length - 1; i++){
            nextInterval = Math.max(nextInterval, i + nums[i]);
            if(i == currInterval){
                currInterval = nextInterval;
                jumps++;
            }
        }
        return jumps;
    }
}

// *****************************************
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// BFS approach
class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        int jumps = 0;
        q.add(0); set.add(0);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int idx=0; idx<size; idx++){
                // if we reach the end, then yes we have a path!
                if(idx == nums.length - 1) return jumps; 
                for(int j=1; j<=nums[idx]; j++){
                    if(!set.contains(idx+j)){ 
                        q.add(idx+j);
                        set.add(idx+j);
                    }
                }
            }
            jumps++;
        }
        return jumps;
    }
}

// *****************************************
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Brute Force: DFS approach
class Solution {
    int jumps = Integer.MAX_VALUE;
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        dfs(nums, 0, 0);
        return jumps;
    }
    private void dfs(int[] nums, int idx, int count){
        // base
        if(count > jumps) return;
        if(idx >= nums.length - 1){
            jumps = count;
            return;
        }
        
        // logic
        for(int ju=1; ju <= nums[idx]; ju++){
            dfs(nums, idx+ju, count+1);
        }
    }
}