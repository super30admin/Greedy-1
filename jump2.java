// approch 1
// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {
    // approch 1 bfs with set
    public static int jump(int[] nums) {
        // null
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        if (n == 1)
            return 0;
        // Queue for BFS
        Queue<Integer> q = new LinkedList<>();
        // set for not visiting again
        Set<Integer> set = new HashSet<>();
        q.add(0);
        set.add(0);
        // to get minimum number of paths so we are using level
        int min = 1;
        int temp = Integer.MAX_VALUE;
        // bfs traversal
        while (!q.isEmpty()) {
            // to maintain a level
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // getting first element from the queue
                int curr = q.poll();
                // go over all the posibilities of the jump
                for (int j = curr + 1; j <= curr + nums[curr]; j++) {
                    // if we reach at the last index we update the min and break the loop
                    if (j >= n - 1) {
                        temp = Math.min(temp, min);
                        break;
                    }
                    // if set contains index j that means we already explored
                    // from there so we skip it else we explore
                    if (!set.contains(j)) {
                        set.add(j);
                        q.add(j);
                    }
                }
            }
            // increase the level
            min++;
        }
        return temp;
    }

    // approch 2 greedy
    public static int jump2(int[] nums) {
        // null
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        if (n == 1)
            return 0;
        // next Interval
        int next = nums[0];
        // current Interval
        int curr = nums[0];
        // minimum number of jumps
        int jump = 1;
        // start from index 1 as we are always first jump from index 0
        for (int i = 1; i < n; i++) {
            // update the next with maximum interval
            next = Math.max(next, i + nums[i]);
            // if we are at the current interval's end
            // update the current interval with next interval
            // and increase the jump by 1
            // if current interval is at last index return jump
            if (curr >= n - 1)
                break;
            if (i == curr) {
                curr = next;
                jump++;
            }
        }
        return jump;

    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, 1, 1, 4, 5, 1, 1, 1, 1, 1, 10 };
        System.out.println(jump(nums));
        System.out.println(jump2(nums));

    }
}