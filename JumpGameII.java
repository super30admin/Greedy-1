/**
 * Greedy BFS-level traversal where each range [l, r] represents all positions reachable with the current number of jumps.
 * For every level, compute the farthest reachable index and expand the window until reaching the last index.
 * Time Complexity: O(n), Space Complexity: O(1)
 */
public class JumpGameII {
        public int jump(int[] nums) {
        int answer = 0;
        int l = 0, r =0;

        while (r<nums.length - 1) {
            int farthest = 0;
            for (int i = l; i <=r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            answer++;
        }

        return answer;
    }
}
