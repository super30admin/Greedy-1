// Time Complexity : O(exponential)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We do this using bfs approach
// We check if we can reach the last index of the array using the values given
// then we add the new indexes onto the queue and continue
// we take levels and when ever we get the index as last index we return the jumps

class Solution {

    public int jump(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        int jumps = 0;
        visited.add(0);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int index = q.poll();
                for (int i = 1; i <= nums[index]; i++) {
                    int newid = index + i;
                    if (newid == nums.length - 1)
                        return jumps + 1;
                    if (!visited.contains(newid)) {
                        q.add(newid);
                        visited.add(newid);
                    }
                }
            }
            jumps++;
        }
        return -1;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We do this using greedy approach
// we take curr and next and assign it to first element
// We calculate next every time and if i == curr we increment jumps and take
// curr as next

class Solution {

    public int jump(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        int n = nums.length;
        int jumps = 1, curr = nums[0], next = nums[0];
        for (int i = 0; i < n - 1; i++) {
            next = Math.max(next, i + nums[i]);
            if (i == curr) {
                jumps++;
                curr = next;
            }
        }
        return jumps;
    }
}