/**
 * Greedy approach: start from the last index and move backwards, updating the goal
 * whenever the current index can reach the goal. If we can eventually move the goal
 * to index 0, then the last index is reachable.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        
        for(int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }
}   
