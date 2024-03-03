import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGame {

    public boolean canJump(int[] nums) {
        return canJumpFromStart(nums);
        // return canJumpFromEnd(nums);
        // return canJumpBFS(nums);
    }

    // TC: O(N*N) where N is length of array
    // SC: O(N*N) where N is length of array
    private boolean canJumpBFS(int[] nums) {
        int n = nums.length;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(0);
        visited.add(0);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == n - 1) return true;
            for (int i = 1; i <= nums[curr]; i++) {
                int neighbor = curr + i;
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return false;
    }

    // TC: O(N*N) where N is length of array
    // SC: O(1)
    private boolean canJumpFromEnd(int[] nums) {
        int n = nums.length;
        int target = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] + i >= target) {
                target = i;
            }
        }
        return target == 0;
    }

    // TC: O(N*N) where N is length of array
    // SC: O(1)
    private boolean canJumpFromStart(int[] nums) {
        int possibleToReach = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > possibleToReach) {
                return false;
            }
            possibleToReach = Math.max(possibleToReach, nums[i] + i);
        }
        return true;
    }
}
