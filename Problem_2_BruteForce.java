// Time complexity - O(n^n)
// Space complexity - O(n)

class Solution {
    int min;
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        min = Integer.MAX_VALUE;
        dfs(nums,0,0);
        return min;
    }
    
    private void dfs(int[] nums, int i, int jumps){
        // base
        if(i >= nums.length-1){
            min = Math.min(min,jumps);
            return;
        }
        // logic
        for(int j = 1; j <= nums[i] ;j++){
            dfs(nums,i+j, jumps+1);
        }
    }
}
