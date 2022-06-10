// Time Complexity: O(n) where n is the length of the array.
// Space Complexity: O(1).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) return true;
        int destination = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            if(i + nums[i] >= destination) destination = i;
        }
        return destination == 0;
    }
    
    //HashSet<Integer> visited;       // For storing indices.
    // Brute force approach.
//     public boolean canJump(int[] nums) {
//         if(nums == null || nums.length < 2) return true;
        
//         Queue<Integer> q = new LinkedList<>();
//         visited = new HashSet<>();
//         q.add(0);
//         visited.add(0);     // Initially, add index 0.
//         // BFS
//         while(!q.isEmpty()) {
//             int curr = q.poll();
//             for(int i = 1; i <= nums[curr]; i++) {
//                 int idx = i + curr;
//                 if(idx == nums.length - 1) return true;
//                 if(!visited.contains(idx)) {
//                     q.add(idx);
//                     visited.add(idx);
//                 }
//             }
//         }
//         return false;
//     }
    
//     // DFS
//     HashSet<Integer> visited;       // For storing indices.
//     public boolean canJump(int[] nums) {
//         if(nums == null || nums.length < 2) return true;
//         visited = new HashSet<>();
//         return dfs(nums, 0);
//     }
         
//     private boolean dfs(int[] nums, int idx) {
//         // base
//         if(visited.contains(idx)) return false;
//         if(idx == nums.length - 1) return true;
//         // logic
//         visited.add(idx);
//         for(int i = 1; i <= nums[idx]; i++) {
//             int newIdx = idx + i;
//             if(dfs(nums, newIdx)) {
//                 return true;
//             }
//         }
//         return false;
//     }
}