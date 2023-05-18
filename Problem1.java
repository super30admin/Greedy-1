// Time: O(n)
// Space O(n)


class Solution {
    public boolean canJump(int[] nums) {
        // TLE BFS
        // if(nums.length <2) return true;
        // Queue<Integer> q = new LinkedList<>();
        // q.add(0);
        // while(!q.isEmpty()){
        //     int cur = q.poll();
        //     for(int i = 1 ; i<=nums[cur];i++){
        //         int curIndex = cur+i;
        //         if(curIndex>=nums.length-1){
        //             return true;
        //         }
        //         q.add(curIndex);
        //     }
        // }

        // return false;

        // DFS
        // return dfs(nums,0);

        // Optimized O(n)
        int curIdx = nums.length-1;

        for(int i = nums.length-2 ; i>=0; i--){
            if(nums[i] + i >= curIdx){
                curIdx = i;
                if(i <= 0 ){
                    return true;
                }
            }
        }
        return curIdx<=0;
    }


    private boolean dfs(int[] nums, int idx){
        if(idx >= nums.length-1) return true;

        for(int i = 1; i<=nums[idx] ; i++){
            int curIdx = idx +i;
            if(dfs(nums, curIdx))
                return true;
        }
        return false;
    }
}