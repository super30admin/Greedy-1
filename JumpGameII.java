// Time Complexity : O(n)
// Space Complexity : O(1)
// n is the length of given array nums
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Greedy
class Solution {
    public int jump(int[] nums) {
        int jumps = 1;
        if(nums.length < 2) return 0;
        int currInt = nums[0];
        int nextInt = nums[0];

        for(int i = 0 ; i < nums.length ; i++){
            nextInt = Math.max(nextInt,i+nums[i]);
            if(i == currInt && i != nums.length-1){
                jumps++;
                currInt = nextInt;
            }
        }
        return jumps;
    }
}

//DFS
//TLE on LC
class Solution {
    int minJumps;
    public int jump(int[] nums) {
        minJumps = Integer.MAX_VALUE;
        if(nums.length < 2)
            return 0;
        dfs(nums,0 ,0);
        return minJumps;
    }

    private void dfs(int[] nums, int idx, int jumps){
        //base case
        if(idx >= nums.length -1){
            minJumps = Math.min(minJumps,jumps);
            return;
        }
        //logic
        for(int i = 1; i <= nums[idx] ; i++){
            int newIdx = i + idx ;
            dfs(nums,newIdx,jumps+1);
        }
    }
}

//BFS
//Accepeted in LC
class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2)
            return 0;
        int jumps = 1;

        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        set.add(0);

        while(!q.isEmpty()){
            int size = q.size();
            for(int k = 0 ; k < size ; k++){
                int curr = q.poll();
                for(int i = 1; i <= nums[curr] ; i++){
                    int newIdx = i + curr;
                    if(newIdx == nums.length -1){
                        return jumps;
                    }
                    if(!set.contains(newIdx)){
                        q.add(newIdx);
                        set.add(newIdx);
                    }
                }
            }
            jumps++;
        }
        return 1000;
    }
}

