//TC: O(n)
//SC: O(1)

public class jump_game_2 {
    class Solution {
        public int jump(int[] nums) {
            int jumps = 0, farthest = 0;
            int left = 0, right = 0;
            while (right < nums.length - 1) {
                for (int i = left; i <= right; ++i)
                    farthest = Math.max(farthest, i + nums[i]);
                left = right + 1;
                right = farthest;
                ++jumps;
            }
            return jumps;
        }
    }
}
