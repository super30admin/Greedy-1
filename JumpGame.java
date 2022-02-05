// Time Complexity : O(exponential)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We do this using dfs approach
// We check if we can reach the last index of the array using the values given
// then we do the dfs on it

class Solution {
    HashSet<Integer> visited;

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2)
            return true;
        visited = new HashSet<>();
        return dfs(0, nums);
    }

    public boolean dfs(int index, int[] nums) {
        if (visited.contains(index))
            return false;
        if (index == nums.length - 1)
            return true;

        visited.add(index);

        for (int i = 1; i <= nums[index]; i++) {
            if (dfs(i + index, nums)) {
                return true;
            }
        }
        return false;
    }
}

// Time Complexity : O(exponential)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We do this using bfs approach
// We check if we can reach the last index of the array using the values given
// then we add the new indexes onto the queue and continue

class Solution {
    HashSet<Integer> visited;

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2)
            return true;
        visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        visited.add(0);
        while (!q.isEmpty()) {
            int index = q.poll();
            for (int i = 1; i <= nums[index]; i++) {
                int newid = index + i;
                if (newid == nums.length - 1)
                    return true;
                if (!visited.contains(newid)) {
                    q.add(newid);
                    visited.add(newid);
                }
            }
        }
        return false;
    }

}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We do this using greedy approach
// we take the destination as n-1
// We check if we can reach the last index by doing nums[i] + i, then we change
// destination as i
// We return destination == 0 as result
class Solution {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2)
            return true;
        int n = nums.length;
        int destination = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] + i >= destination) {
                destination = i;
            }
        }
        return destination == 0;
    }

}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We do this using greedy approach
// we take the steps as 1
// We check if we can reach the last index by doing nums[i] >= steps, if not we
// increase the steps
// We return nums[0] >= steps as result
class Solution {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2)
            return true;
        int n = nums.length;
        int steps = 1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] >= steps) {
                steps = 1;
            } else
                steps++;
        }
        return nums[0] >= steps;
    }

}