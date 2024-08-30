// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return 0;
        int currInt = nums[0];
        int nextInt = nums[0];
        int jumps = 1;

        for (int i = 0; i < n; i++) {
            nextInt = Math.max(nextInt, i + nums[i]);
            if (currInt >= n - 1)
                return jumps;
            if (i == currInt) {
                currInt = nextInt;
                jumps++;
            }
        }

        return 0;

    }
}