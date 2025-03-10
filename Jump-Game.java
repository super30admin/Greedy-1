## Problem1 Jump Game (https://leetcode.com/problems/jump-game/)
//Approach 1: Brute force approach : In this we go on exploring every possible combinations. It forms a tree and then we can use any traversal
// BFS or DFS to do it

//Using BFS traversal
// We are maintaining a hashset to keep track of elements which are processed. If we don't do that then we will again and again process 
// Same element. 
// Time complexity : O(n)
// Space Complexity : O(n) 
class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length==0 || nums.length==1){
            return true;
        }
        int n=nums.length;
        Queue<Integer> q=new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(0);
        set.add(0);
        while(!q.isEmpty()){
            int polled = q.poll();
            for(int i=1;i<=nums[polled];i++){
                if(!set.contains(polled+i)){
                    if(polled+i==n-1){
                        return true;
                    }
                    q.add(polled+i);
                    set.add(polled+i);
                }
            }
        }
        return false;
    }
}

//DFS
class Solution {
    HashSet<Integer> set;
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length==0 || nums.length==1){
            return true;
        }
        int n=nums.length;
        set = new HashSet<>();
        return dfs(0,n-1,nums);
     
    }
    private boolean dfs(int n, int target, int[] nums){
        //base
        if(n==target){
            return true;
        }
        if(set.contains(n)){
            return false;
        }
        //iteration
        set.add(n);
        for(int i=1;i<=nums[n];i++){
                if(dfs(n+i,target,nums)){
                    return true;
                }  
        }
        return false;
    
    }
}


//Optimal Solution
// Time Complexity :O(n)
// Space Complexity : O(1)
class Solution {
    HashSet<Integer> set;
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length==0 || nums.length==1){
            return true;
        }
        int n =nums.length-1;
        int destination = n-1;
        for(int i=n-2;i>=0;i--){
            if(i+nums[i]>=destination){
                destination = i;
            }
        }
        if(destination==0){
            return true;
        }
        return false;
    }
}