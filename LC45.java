// TC: O(n)
// SC: O(1)

public class LC45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int steps = 0;
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == end) {
                end = max;
                steps++;
            }
        }
        return steps;
    }
}
