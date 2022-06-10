// Time Complexity: O(n) where n is the length of the array.
// Space Complexity: O(1).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class JumpGame2 {
    public int jump(int[] nums) {
        if(nums.length < 2 || nums == null) return 0;
        int jumps = 1;
        // Using 2 intervals, curr and next.
        int curr = nums[0];
        int next = nums[0];
        for(int i = 0; i < nums.length; i++) {
            next = Math.max(next, i + nums[i]);     // Max index reached form index i.
            // Optimization
            if(curr < next && next >= nums.length - 1) 
                return jumps + 1;
            else if(next >= nums.length - 1) 
                return jumps;
            if(i < nums.length - 1 && i == curr) {  // i shouldn't be the last index.
                jumps++;
                curr = next;
            }
        }
        return jumps;
    }
    // Brute Force Approach (BFS)
    // public int jump(int[] nums) {
    //     if(nums == null || nums.length < 2) return 0;
    //     Queue<Integer> q = new LinkedList<>();
    //     HashSet<Integer> visited = new HashSet<>();
    //     q.add(0);
    //     visited.add(0);
    //     int lvl = 0;
    //     while(!q.isEmpty()) {
    //         int size = q.size();
    //         for(int i = 0; i < size; i++) {
    //             int curr = q.poll();
    //             for(int j = 1; j <= nums[curr]; j++) {
    //                 int idx = j + curr;
    //                 if(idx == nums.length - 1) {
    //                     return lvl + 1;
    //                 }
    //                 if(!visited.contains(idx)) {
    //                     visited.add(idx);
    //                     q.add(idx);
    //                 }
    //             }
    //         }
    //         lvl++;
    //     }
    //     return 12454;       // Never runs.
    // }
}