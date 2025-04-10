// TC: O(n)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // Brute Force - BFS
    // public boolean canJump(int[] nums) {
    //     int n = nums.length;
    //     if(nums == null || n == 0 || n == 1) return true;
    //     Queue<Integer> q = new LinkedList<>();
    //     HashSet<Integer> visited = new HashSet<>();
    //     q.add(0);
    //     visited.add(0);
    //     while(!q.isEmpty()) {
    //         int curr = q.poll();
    //         for(int i = 1; i <= nums[curr]; i++) { // try jumping from 1 - nums[curr]
    //             int child = curr + i;
    //             if(child == n - 1) {
    //                 return true; // able to go to destination
    //             }
    //             if(!visited.contains(child)) {
    //                 visited.add(child);
    //                 q.add(child);
    //             }
    //         }
    //     }
    //     return false;
    // }

    // Brute Force - DFS
    // HashSet<Integer> visited;
    // public boolean canJump(int[] nums) {
    //     int n = nums.length;
    //     if(nums == null || n == 0 || n == 1) return true;
    //     visited = new HashSet<>();
    //     return dfs(0, nums.length - 1, nums);
    // }
    // private boolean dfs(int root, int target, int[] nums) {
    //     // base
    //     if(root == target) return true;
    //     if(visited.contains(root)) return false; // dont redo dfs for already visited items
    //     visited.add(root);
    //     for(int i = 1; i <= nums[root]; i++) {
    //         int child = root + 1;
    //         if(dfs(child, target, nums)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // TC = O(n), SC = O(n)
    // Optimized, this is GREEDY.
    // Here we check that if the destination is reachable from the prev element, if yes then update the destn, at the end if destn becomes 0, then return true
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(nums == null || n == 0 || n == 1) return true;
        int destination = n - 1;
        for(int i = n - 2; i >= 0; i--) {
            if(i + nums[i] >= destination) {
                destination = i; // update destn, as curr destn is reachable
            }
        }
        return destination == 0;
    }
}