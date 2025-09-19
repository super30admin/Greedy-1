class Solution {
    // can do bfs and dfs since there are different indexes we can reach from starting. then from there we can visit few other indexes. but they are very slow and explore all paths. sometimes give TLE
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int n = nums.length;
        
        // this also works
        // int cur = nums[0];
        // int next = nums[0];
        // int jumps = 1;

        int cur = 0;
        int next = 0;
        int jumps = 0;

        for (int i = 0; i < n - 1; ++i) {
            next = Math.max(next, i + nums[i]);
            if (i == cur) {
                jumps++;
                cur = next;
            }
        }
        return jumps;
    }
}