// Bruteforce BFS Solution: In this approach, using a queue and a hashset for maintaining visited value. Adding root index to the 
// queue and while queue is not empty, polling the index one by one and checking the value at that index, running a for loop that many
// times and each time computing child index = curr index + i, checking if any of the computed index become equals to the target,
// then returning true else false

// Time Complexity : Exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public boolean canJump(int[] nums) {
        // Base Case
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return true;
        }
        int n = nums.length;
        // Queue for BFS
        Queue<Integer> q = new LinkedList<>();
        // Add first index that is 0 to the queue
        q.add(0);
        // Set for maintaining the visited elements
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        // Loop till q is not empty
        while (!q.isEmpty()) {
            // Poll the current index
            int curr = q.poll();
            // Loop from i=1 to till the value present at the current index, because that is
            // the max jump that can happen from current index
            for (int i = 1; i <= nums[curr]; i++) {
                // Compute the index for jump of length 1, length 2, till length max
                int child = curr + i;
                // Check one by one, if any of the jump index equals to the target means, we
                // reached our destination
                if (child == n - 1) {
                    // So return true
                    return true;
                }
                // Else, if the jump index is not visited earlier, add to the set and queue
                if (!set.contains(child)) {
                    q.add(child);
                    set.add(child);
                }

            }
        }
        // If it comes out without returning true, return false
        return false;
    }
}

// Bruteforce DFS solution:
// Time Complexity : Exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    HashSet<Integer> set;

    public boolean canJump(int[] nums) {
        // Base case
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return true;
        }
        set = new HashSet<>();
        // Make the dfs call
        return dfs(0, nums.length - 1, nums);
    }

    private boolean dfs(int root, int target, int[] nums) {
        // Base
        if (root == target) {
            return true;
        }
        // If our root is not equal to the target, and set already contains root, that
        // means it was already visited once, so no need to visit again
        if (set.contains(root)) {
            return false;
        }
        // Else, if it is first time, then add to the set
        set.add(root);
        // And make different length jumps 1,2,...max from this current index and make
        // the dfs call from there
        for (int i = 1; i <= nums[root]; i++) {
            if (dfs(root + i, target, nums)) {
                return true;
            }
        }
        // Else return false
        return false;
    }
}

// Optimize:
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    HashSet<Integer> set;

    public boolean canJump(int[] nums) {
        // Base case
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return true;
        }
        // Keep a destination index as n-1
        int dest = nums.length - 1;
        // Now loop from second last index, and check one one element
        for (int i = nums.length - 2; i >= 0; i--) {
            // Check if from second last index is it possible to reach dest, if yes change
            // the new destination as current index and move i to third last index... and so
            // on
            if (nums[i] + i >= dest) {
                dest = i;
            }
        }
        // At last if destination index becomes zero, means we were able to reach all
        // destination
        return dest == 0;
    }

}