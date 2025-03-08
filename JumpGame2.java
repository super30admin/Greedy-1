// In this bruteforce approach, maintaining a level while doing BFS, whenever any child value becomes equal to the destination index
// returning level+1. Otherwise if that child is not visited earlier, adding that to set and queue and moving to next.

// Time Complexity : Exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int jump(int[] nums) {
        // Base Case
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        // Queue for BFS
        Queue<Integer> q = new LinkedList<>();
        // Add the first index to the queue
        q.add(0);
        // HashSet for keeping track of visited indices
        HashSet<Integer> set = new HashSet<>();
        // Add first index to the set
        set.add(0);
        // Maintain a level variable
        int level = 0;
        // nums.length --> n
        int n = nums.length;
        // Loop till queue is not empty
        while (!q.isEmpty()) {
            // Keep to size variable to process level wise
            int size = q.size();
            // Loop till size
            for (int i = 0; i < size; i++) {
                // Poll the current
                int curr = q.poll();
                // Check each level jump from this current index, check if any jump leads to the
                // destination index, in that case return level + 1
                for (int j = 1; j <= nums[curr]; j++) {
                    // if nums[curr] value suppose it's 3 then child will be 1+curr, 2+curr, 3+curr
                    int child = curr + j;
                    // Check if any jump is equal to destination index
                    if (child == n - 1) {
                        // In that case return level+1
                        return level + 1;
                    }
                    // If not the destination index, check if it's already visited, if not, add it
                    // to the queue and set
                    if (!set.contains(child)) {
                        q.add(child);
                        set.add(child);
                    }
                }

            }
            // Increase the level
            level++;
        }
        // Return level
        return level;
    }
}

// In this optimize approach, keeping few variables, currInterval, nextInterval
// both initially assigned nums[0], and jumps as 1
// initially. Running a loop on nums array and explain all the indices in the
// current interval, and next interval holds the value
// of the index where you can reach max with 1 jump. Then when i becomes, equal
// to the currInt, we increment jumps by 1 and
// update the currInt with the value of nextInt. In end return jumps, for
// knowing the min jumps required to reach destination.

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int n = nums.length;
        int currInt = nums[0];
        int nextInt = nums[0];
        int jumps = 1;
        for (int i = 0; i < n; i++) {
            nextInt = Math.max(nextInt, nums[i] + i);
            if (i < n - 1 && currInt == i) {
                jumps++;
                currInt = nextInt;
            }
        }
        return jumps;
    }
}