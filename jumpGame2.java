import java.util.*;

/*
 * Approach 2 (optimized)
 * We use a Greedy approach where we calculate the number of intervals we can
 * reach from a particular index. This way, we can find the maximum possible
 * jump from any index to find the next greatest interval, which would skip
 * over some of the shorter intervals (i.e., shorter jumps).
 */

// TC - O(n)
// SC - O(1)

class Solution2 {
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return 0;
        }

        int jumps = 1; // at least 1 jump is needed since length >= 2 guaranteed
        // initialize our intervals to the max jumps possible from index 0
        int currInt = nums[0]; // current interval
        int nextInt = nums[0]; // next interval

        for(int i = 1; i < nums.length; i++) {
            // update next interval based on maximization of jumps from
            // current position
            nextInt = Math.max(nextInt, i + nums[i]);
            // only check until we're at the end
            if(i < nums.length-1 && i == currInt) {
                jumps++; // at the end of current interval, we have taken 1 jump
                currInt = nextInt; // then we move to next interval
            }
        }

        return jumps;
    }
}

/*
 * Approach 1
 * We can use BFS on the "tree of recursion" in order to find the earliest
 * occurence of the last index in a particular path (which is basically the
 * earliest level where we encounter the last index). The answer is this
 * earliest level where we find the last index.
 */

// TC - O(n^m)
// SC - O(n) for Q and HashSet

class Solution1 {
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return 0;
        }

        Queue<Integer> q = new LinkedList<>(); // for BFS
        HashSet<Integer> visited = new HashSet<>(); // visited set
        int jumps = 0; // basically the tree level

        q.add(0); // start from index 0

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int curr = q.poll();
                for(int j=1; j <= nums[curr]; j++) {
                    int child = curr + j;
                    if(child == nums.length-1) {
                        return jumps + 1;
                    }
                    // process the index if not visited before
                    if(!visited.contains(child)) {
                        visited.add(child);
                        q.add(child);
                    }
                }
            }
            jumps++;
        }

        return 0; // never reached, we will always get a valid answer
    }
}