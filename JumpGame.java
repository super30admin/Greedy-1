// Time Complexity : O(n)
// Space Complexity : O(1)
// n is the length of given array nums
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//App 5: Greedy
//TC: O(n)
//SC: O(1)

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length -1;
        int dest = n;

        for(int i = n-1 ; i >= 0 ; i--){
            if(i+nums[i] >= dest){
                dest = i;
            }
        }
        return dest == 0;
    }
}
//App 4: DFS with Optimization with dp array (memoization)
//TC: exponential
//Accepted in LC
class Solution {
    int[] dp; // -1 -> not visited ; 1 -> visited ; 2 -> visited but from that index not able to reach dest
    public boolean canJump(int[] nums) {
        if(nums.length < 2)
            return true;
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return dfs(nums,0);
    }

    private boolean dfs(int[] nums,int idx){
        //base case
        if(idx >= nums.length-1)
            return true;
        if(dp[idx] == 2)
            return false;
        //logic
        dp[idx] = 1;
        for(int i = 1 ; i <= nums[idx] ; i++){
            int newIdx = idx+i;
            if((dp[newIdx] == -1) && dfs(nums,newIdx))
                return true;
        }
        dp[idx] = 2;
        return false;
    }
}

//App 3: DFS
// TLE in leetcode
//TC: exponential


class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length < 2)
            return true;
        return dfs(nums,0);
    }

    private boolean dfs(int[] nums,int idx){
        //base case
        if(idx >= nums.length-1)
            return true;

        //logic
        for(int i = 1 ; i <= nums[idx] ; i++){
            if(dfs(nums,idx+i))
                return true;
        }
        return false;
    }
}

// App 2 : BFS with optimization using set
//TC: exponential
//Accepted in LC
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length < 2 ) return true;
        int n = nums.length -1;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.add(0);
        set.add(0);

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int i = 1 ; i <= nums[curr] ; i++){
                int newIdx = curr + i;
                if(newIdx >= n)
                    return true;
                if(!set.contains(newIdx)){
                    q.add(newIdx);
                    set.add(newIdx);
                }
            }
        }
        return false;


// App 1 : BFS
// TLE in leetcode
// TC: exponential
 class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length < 2 ) return true;
        int n = nums.length -1;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.add(0);
        set.add(0);

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int i = 1 ; i <= nums[curr] ; i++){
                int newIdx = curr + i;
                if(newIdx >= n)
                    return true;
                if(!set.contains(newIdx))
                    q.add(newIdx);
                set.add(newIdx);
            }
        }
        return false;
    }
}
