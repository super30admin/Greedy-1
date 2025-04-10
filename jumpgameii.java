// TC: O(n)
// SC: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // Brute Force BFS, we are exploring all the options & returning the level when nums[n - 1] is queued
    // public int jump(int[] nums) {
    //     int n = nums.length;
    //     if(nums == null || n == 0 || n == 1) return 0;
    //     HashSet<Integer> visited = new HashSet<>();
    //     Queue<Integer> q = new LinkedList<>();
    //     int level = 0;
    //     q.add(0); // adding index
    //     visited.add(0);
    //     while(!q.isEmpty()) {
    //         int size = q.size();
    //         for(int i = 0; i < size; i++) {
    //             int curr = q.poll();
    //             for(int j = 1; j <= nums[curr]; j++) { // adding the child
    //                 int child = curr + j; // no. of steps from the index
    //                 if(child == n - 1) {
    //                     return level + 1; // reached n - 1
    //                 }
    //                 if(!visited.contains(child)) {
    //                     q.add(child);
    //                     visited.add(child);
    //                 }
    //             }
    //         }
    //         level++; // keeping track of level for no. of steps
    //     }
    //     return -1;
    // }

    // Optimized, TC = O(n), SC = O(1)
    public int jump(int[] nums) {
        int n = nums.length;
        if (nums == null || n <= 1 ) return 0;
        int currInterval = nums[0]; // the values that Im inspecting currently
        int nextInterval = nums[0]; // the farthest that I can go
        int jumps = 1; // no. of jumps that I took
        for(int i = 0; i < n; i++) {
            nextInterval = Math.max(i + nums[i], nextInterval);
            if(i < n - 1 && i == currInterval) { // only jump when we have not reached n-1
                currInterval = nextInterval;
                jumps++;
            }
        }
        return jumps;
    }
}