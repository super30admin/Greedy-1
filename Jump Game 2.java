class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] jumps = new int[n];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;
        for (int i = 0; i < n; i++) {
            if (jumps[i] == Integer.MAX_VALUE)
                continue;
            for (int j = i + 1; j <= i + nums[i] && j < n; j++) {
                jumps[j] = Math.min(jumps[i] + 1, jumps[j]);
            }
        }
        return jumps[n - 1];
    }
}
