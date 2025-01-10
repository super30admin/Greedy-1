//45. Jump Game 2 - https://leetcode.com/problems/jump-game-ii/description/

//Time Complexity: O(n^2)
//Space Complexity: O(n)
//BFS + Memoization
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        //base case
        if(n == 1) return 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(0); //add first index

        //HashSet to memoize the visited index
        //equivalent to visited set
        HashSet<Integer> memoSet = new HashSet<>();
        memoSet.add(0);

        //to track minimum no. of jump
        int level=0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int currIdx = q.poll();
                for(int k=1; k<=nums[currIdx]; k++){
                    int newIdx = currIdx + k;
                    if(newIdx >= n-1) return level+1;
                    //check the index if its present in HashSet before adding it in the Queue
                    if(!memoSet.contains(newIdx)){
                        q.add(newIdx); //add to both queue and set
                        memoSet.add(newIdx);
                    }
                }
            }
            level++;
        }
        return 1;
    }
}

//DFS - Time Limit Exceeded
class Solution {
    int minJumps,n;
    public int jump(int[] nums) {
        this.n = nums.length;
        //base case
        if(n == 1) return 0;

        this.minJumps = Integer.MAX_VALUE;
        dfs(nums, 0, 0);
        return minJumps;
    }

    private void dfs(int[] nums, int currIdx, int jumps) {
        //base case
        if(currIdx >= n-1){
            minJumps = Math.min(minJumps, jumps);
            return;
        }
        //logic
        for(int k=1; k<=nums[currIdx]; k++){
            int newIdx = currIdx + k;
            dfs(nums, newIdx, jumps+1);
        }

    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)
//Greedy Approach
class Solution {
    int minJumps,n;
    public int jump(int[] nums) {
        this.n = nums.length;
        //base case
        if(n == 1) return 0;

        int currInterval = nums[0];
        int nextInterval = nums[0];
        int jumps = 1; //initial jump is 1
        for(int i=1; i<n; i++){
            nextInterval = Math.max(nextInterval, nums[i]+i);
            //if we have reached last index, no jumps needed
            //since i is already at last place (i!=n-1)
            if(i!=n-1 && i == currInterval){
                currInterval = nextInterval;
                jumps++;
            }
            if(currInterval >= n-1){
                return jumps;
            }
        }
        return 1;
    }
}