class Solution {
    public int jump(int[] nums) {
        // Tc: O(n) Sc: O(1)
        int n = nums.length;
        int cnt = 0;
        int dest = 0;
        int window = 0;

        for (int i = 0; i < n - 1; i++) {
            window = Math.max(window, i + nums[i]);

            if (i == dest) {
                cnt++;
                dest = window;
            }
        }
        return cnt;
    }
}