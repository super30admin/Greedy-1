// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//linear solution
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) {
            return true;
        }
        
        /* dest is last index and start from backwards if we
        can reach dest using any previous index and num at that index,
        if yes, change dest to that index.
        if dest becomes zero, there is a valid path that can lead to last index
        */
        
        int dest = nums.length-1;
        
        for(int i = dest -1; i>= 0 ; i--) {
            if(nums[i] + i >= dest) {
                dest = i;
            }
        }
        
        if(dest == 0)
            return true;
        else
            return false;
    }
    
}

//exponential recrusive solution
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) {
            return true;
        }
        
        //exponential recursive solution
        return dfs(nums, 0);
    }
    
    private boolean dfs(int[] nums, int i) {
        //base
        if( i == nums.length -1) return true;
        
        //logic
        for(int j=1 ;j<= nums[i]; j++){
            if(dfs(nums, i+j)) return true;
        }
        
        return false;
    }
}