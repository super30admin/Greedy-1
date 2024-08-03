class Solution {
    HashSet<Integer> visited;
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) {
            return true;
        }
        // BFS
        // Queue<Integer> q = new LinkedList<>();
        // HashSet<Integer> visited = new HashSet<>();
        // q.add(0);
        // visited.add(0);
        // while(!q.isEmpty()) {
        //     int curr = q.poll();
        //     for(int i = 1; i <= nums[curr]; i++) {
        //         int jump = i + curr;
        //         if(jump == nums.length - 1) {
        //             return true;
        //         }
        //         if(!visited.contains(jump)) {
        //             visited.add(jump);
        //             q.add(jump);
        //         }
        //     }
        // }
        // return false;

        //DFS
        // visited = new HashSet<>();
        // return dfs(nums, 0);

        //New logic for destination - moving from end to start
        int destination = nums.length - 1;
        int n = nums.length;
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] + i >= destination) {
                destination = i;
            }
        }
        return destination == 0;
    }

    private boolean dfs(int[] nums, int s) {
        // base
        if(s == nums.length - 1) {
            return true;
        }
        if(visited.contains(s)) {
            return false;
        }
        //logic
        visited.add(s);
        for(int i = 1; i <= nums[s]; i++) {
            int jump = s + i;
            if(dfs(nums, jump)) {
                return true;
            }
        }
        return false;
    }
}
