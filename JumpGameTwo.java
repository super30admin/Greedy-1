class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        // Brute force with k array tree
        // Queue<Integer> q = new LinkedList<>();
        // HashSet<Integer> visited = new HashSet<>();
        // int lvl = 0;
        // q.add(0);
        // visited.add(0);
        // while(!q.isEmpty()) {
        //     int size = q.size();
        //     for(int i = 0; i < size; i++) {
        //         int curr = q.poll();
        //         if(curr == nums.length - 1) {
        //             return lvl;
        //         }
        //         for(int j = 1; j <= nums[curr]; j++) {
        //             int jump = curr + j;
        //             if(!visited.contains(jump)) {
        //                 q.add(jump);
        //                 visited.add(jump);
        //             }
        //         }
        //     }
        //     lvl++;
        // }
        // return 0;

        // Using 3 variables
        int jumps = 1;
        int currInterval = nums[0];
        int nextInterval = nums[0];
        for(int i = 0; i < nums.length; i++) {
            nextInterval = Math.max(nextInterval, i + nums[i]);
            if(i == currInterval) {
                currInterval = nextInterval;
                if(i != nums.length - 1) {
                    jumps += 1;
                }
            }
        }
        return jumps;
    }
}
