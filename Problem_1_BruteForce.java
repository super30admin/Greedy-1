// Time complexity - O(n^n)
// Space complexity - O(n) {recursive stack}
// Explore all paths
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length  < 2) return true;
        return dfs(nums,0);
    }
    
    private boolean dfs(int[] nums, int i){
        // base
        if( i == nums.length - 1) return true;
        
        // logic
        for(int j = 1;  j <= nums[i]; j++){
          if(dfs(nums, i+j)) return true;
        }
        
        return false;
    }
}
