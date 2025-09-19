class Solution {
    // can do bfs and dfs since there are different indexes we can reach from starting. 
    // then from there we can visit few other indexes. but they are very slow and 
    // explore all paths. sometimes give TLE
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return true;
        }
        int n = nums.length;
        int target = n - 1;
        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] + i >= target) {
                target = i;
            }
        }

        return target == 0;
        
    }
}