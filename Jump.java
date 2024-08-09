// Time Complexity : O(n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to learn

/*
 * Problem# : 55 Jump Game
 * 
 */

import java.util.*;

public class Jump {

    // It can be solved as a tree, and we can do either BFS or DFS. We have to
    // return if its possible to reach the end, so the shortest would suffice, so
    // BFS.
    // Time compleixty: O(k^n); Space Complexity: O(n)
    public boolean canJump_BFS(int[] nums) {
        if (nums.length <= 1)
            return true;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(0);// adding the index
        set.add(0);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 1; i <= nums[current]; i++) {
                int newIndex = current + i;
                if (newIndex >= nums.length - 1)
                    return true;
                if (!set.contains(newIndex)) {
                    set.add(newIndex);
                    queue.add(newIndex);
                }
            }
        }

        return false;
    }

    Set<Integer> cache;

    // using DFS
    // Time compleixty: O(k^n); Space Complexity: O(n)
    public boolean canJump_DFS(int[] nums) {
        if (nums.length <= 1)
            return true;
        cache = new HashSet<>();
        return dfs(0, nums);
    }

    public boolean dfs(int currIndex, int[] nums) {
        // base case
        if (currIndex >= nums.length - 1)
            return true;

        if (cache.contains(currIndex))
            return false;

        // logic
        for (int i = 1; i <= nums[currIndex]; i++) {
            int newIndex = currIndex + i;
            if (!cache.contains(newIndex)) {
                if (dfs(newIndex, nums)) {
                    return true; // we only return true if dfs is true, or else we continue with other newIndexes
                }
            }
        }

        cache.add(currIndex);// there is a reason to add it here. If its coming here that means the above for
                             // loop didnt return true, so if a cache contains currentIndex its not a valid
                             // path.
        return false;
    }

    // Optimized solution: Think about this mental model, Invert always invert
    /*
     * What if we solve from bottom to top...
     * 
     */
    public boolean canJump(int[] nums) {
        if (nums.length <= 1)
            return true;
        int n = nums.length;
        int currIndx = nums.length - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (currIndx <= i + nums[i]) {
                currIndx = i;
            }
        }

        return currIndx == 0;

    }
}
