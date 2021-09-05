// Time Complexity : O(exp)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class jump2DFS {
    int minJumps;

    public int jump(int[] nums) {
        if(nums == null || nums.length < 2)
            return 0;
        
        minJumps = Integer.MAX_VALUE;
        
        dfs(0, nums, 0);
        return minJumps;
    }
    
    private void dfs(int index, int[] nums, int jumps){
        //base
        
        if(index == nums.length - 1){
            minJumps = Math.min(minJumps, jumps);
            return;
        }
            
        //logic
        for(int i = 1; i <= nums[index]; i++){
            int newIndex = index + i;
            dfs(newIndex, nums, jumps + 1);
        }
    }
}