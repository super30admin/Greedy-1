// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) return true;
        int destination = nums.length - 1;
        
        for(int i = nums.length - 2; i>=0; i--){
            if(i + nums[i] >= destination)
                destination = i;
        }
        return destination == 0;
    }
}

// ********************************************
// Time Complexity : O(exponential)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// BFS approach - exponential
class Solution {
    HashSet<Integer> set;
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) return true;
        Queue<Integer> q = new LinkedList<>();
        set = new HashSet<>();
        
        q.add(0); set.add(0);
        
        while(!q.isEmpty()){
            int idx = q.poll();
            
            // if we reach the end, then yes we have a path!
            if(idx == nums.length - 1) return true; 
            // else
            for(int j=1; j<=nums[idx]; j++){
                if(idx+j >= nums.length-1) return true;
                if(!set.contains(idx+j)){ 
                    q.add(idx+j);
                    set.add(idx+j);
                }
            }
        }
        return false;
    }
}

// ***********************************************
// Time Complexity : O(exponential)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// DFS approach

class Solution {
    HashSet<Integer> set;
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) return true;
        set = new HashSet<>();
        return dfs(nums, 0);
    }
    private boolean dfs(int[] nums, int idx){
        // base
        if(idx >= nums.length - 1)
            return true;
        
        // logic
        set.add(idx);
        for(int j=1; j<= nums[idx]; j++){
            if(!set.contains(idx+j) && dfs(nums, idx+j)) return true;
        }
        return false;
    }
}
