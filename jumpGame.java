import java.util.*;

/*
* Approach 2 (optimized)
* Using reverse loop and a Greedy approach to solving this problem.
* We start counting from reverse to see whether we can even reach the starting
* from the end. This way, the solution can always be found.
*/

// TC - O(n)
// SC - O(1)

class Solution2 {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return true;
        }

        int n = nums.length;
        int destination = n-1;
        
        for(int i=n-2; i>=0; i--) {
            // in case we're able to reach our destination from current element
            // considering the number of jumps we can take, then we can consider
            // a new destination which is the current index
            if(nums[i] + i >= destination) {
                destination = i; 
            }
        }

        return destination == 0;
    }
}

/*
 * Approach 1
 * We can visualize this problem as a "tree of recursion" where each to the
 * solution can be explored. The path is basically the number of jumps from a
 * particular index that we can take. We use an iterative recusion (BFS)
 * approach to explore all paths, and so we get the correct solution if we find
 * the last index in our path.
 */

// TC - O(n^m)
// SC - O(n) for Q and HashSet

class Solution1 {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return true;
        }

        int n = nums.length;

        // Brute force approach with tree structure
        // and we need to traverse it, so we do BFS
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        // we start from index 0
        q.add(0);
        visited.add(0);

        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int i=1; i<= nums[curr]; i++) {
                int jump = curr + i; // compute all the possible jumps from current index
                if(!visited.contains(jump)) {
                    if(jump == n-1) {
                        return true;
                    }
                    q.add(jump);
                    visited.add(jump);
                }
            }
        }
        
        return false;
    }
}