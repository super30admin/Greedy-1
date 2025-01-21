public class JumpGame{
    //greedy - o(n)
    public boolean canJump(int[] nums){
        int n = nums.length;
        if(n == 1) return true;
        int target = n-1;
        for(int i = n-2; i >= 0; i--){
            if(nums[i] + i >= target){
                target = i;
            }
        }
        return target == 0;
    }

    //dp based memo - o(n^2) 
    // Set<Integer> memoSet;
    // public boolean canJump(int[] nums){
    //     this.memoSet = new HashSet<>();
    //     int n = nums.length;
    //     if(n == 1) return true;
    //     return dfs(nums,0);
    // }

    // public boolean dfs(int[] nums, int currIdx){
    //     //base 
    //     if(currIdx >= nums.length-1){
    //         return true;
    //     }
    //     //means we explored the currIdx before and didnt find the path
    //     if(memoSet.contains(currIdx)) return false;

    //     //logic 
    //     for(int k = 1; k <= nums[currIdx]; k++){
    //         int newIdx = currIdx + k;
    //         if(dfs(nums, newIdx)) return true;
    //     }
    //     memoSet.add(currIdx);  
    //     return false;
    // }

    
    //bfs 
    // public boolean canJump(int[] nums) {
    //     if(nums.length == 1) return true;
    //     Queue<Integer> q = new LinkedList<>();
    //     q.offer(0);
    //     Set<Integer> visited = new HashSet<>();
    //     visited.add(0);
    //     while(!q.isEmpty()){
    //         int currIdx = q.poll();
    //         for(int k = 1; k <= nums[currIdx]; k++){
    //             int newIdx = currIdx + k;
    //             if(newIdx >= nums.length-1) return true;
    //             if(!visited.contains(newIdx)){
    //                 q.offer(newIdx);
    //                 visited.add(newIdx);
    //             }
    //         }
    //     }
    //     return false;
    // }


    //Brute force - o(k^n)
    // public boolean canJump(int[] nums) {
    //     if(nums.length == 1) return true;
    //     Queue<Integer> q = new LinkedList<>();
    //     q.offer(0);
    //     while(!q.isEmpty()){
    //         int currIdx = q.poll();
    //         for(int k = 1; k <= nums[currIdx]; k++){
    //             int newIdx = currIdx + k;
    //             if(nums[newIdx] >= nums.length-1) return true;
    //             q.offer(newIdx);
    //         }
    //     }
    //     return false;
    // }
}