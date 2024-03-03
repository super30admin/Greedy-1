import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGameII {
    public int jump(int[] nums) {
        // return jumpBFS(nums);
        // return jumpDFS(nums);
        return jumpGreedy(nums);
    }

    // TC: O(N) where N is length of array
    // SC: O(1)
    private int jumpGreedy(int[] nums) {
        if (nums.length == 1) return 0;
        int currInterval = nums[0];
        int nextInterval = nums[0];
        int jumps = 1;
        for (int i = 1; i < nums.length; i++) {
            nextInterval = Math.max(nextInterval, i + nums[i]);
            if (i == currInterval && i != nums.length - 1) {
                jumps++;
                currInterval = nextInterval;
            }
        }
        return jumps;
    }

    int minJumps = Integer.MAX_VALUE;
    private int jumpDFS(int[] nums) {
        dfs(nums, 0, 0);
        return minJumps;
    }

    // TC: O(N*N) where N is length of array
    // SC: O(N*N) where N is length of array
    private void dfs(int[] nums, int index, int jumps) {
        if (index >= nums.length - 1) {
            minJumps = Math.min(minJumps, jumps);
            return;
        }
        for (int j = 1; j <= nums[index]; j++) {
            int neighbor = index + j;
            dfs(nums, neighbor, jumps + 1);
        }
    }

    // TC: O(N*N) where N is length of array
    // SC: O(N*N) where N is length of array
    private int jumpBFS(int[] nums) {
        int n = nums.length;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(0);
        visited.add(0);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n - 1) {
                    return level;
                }
                for (int j = 1; j <= nums[curr]; j++) {
                    int neighbor = curr + j;
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            level++;
        }
        return level;
    }
}
