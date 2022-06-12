import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
    //BFS Solution
    // TC : O(n)
    // SC : O(n)
    public int jump1(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        HashSet<Integer> visited = new HashSet<>();

        Queue<Integer> que = new LinkedList<>();

        que.add(0);
        int lvl = 1;
        visited.add(0);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int curr = que.poll();

                for (int j = 1; j <= nums[curr]; j++) {
                    int idx = j + curr;
                    if (idx == nums.length - 1) return lvl;
                    if (!visited.contains(idx)) {
                        visited.add(idx);
                        que.add(idx);
                    }
                }
            }
            lvl++;
        }

        return 23456;
    }

    // Optimal Solution
    // TC : O(n)
    // SC : O(1)
    public int jump2(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int jump = 1;
        int curr = nums[0];
        int next = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            next = Math.max(next, i + nums[i]);

            if (i == curr) {
                curr = next;
                jump++;
            }
        }
        return jump;
    }
}
