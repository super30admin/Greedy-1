// Time Complexity : O(exp)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.*;

class jump1DFS {
    Set<Integer> visited;
    public boolean canJump(int[] nums) {
        if(nums.length == 0 || nums == null)
            return false;
        
        if(nums.length == 1)
            return true;
        
        visited = new HashSet<>();
        return dfs(0, nums);
        
    }
    
    private boolean dfs(int index, int[] nums){
        //base
        if(visited.contains(index)) return false;
        
        if(index == nums.length - 1) return true;
        
        //logic
        visited.add(index);
        for(int i = 1; i <= nums[index]; i++){
            if(dfs(index + i, nums)) return true;
        }
        
        return false;
    }
}