## Problem2 Jump Game II (https://leetcode.com/problems/jump-game-ii/)

//in this we want to  find minimum steps to reach the destination so 
// Brute force approach : we will explore all possible combianations and also maintain a hashset to see if we have already processed it
// if we have processed it then we will not again do it

//BFS
//T.C = O(n)
//S.C = O(n)

class Solution {
    public int jump(int[] nums) {
        //base condition
        if(nums==null || nums.length ==1 ){
            return 0;
        }
        //declaration
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        set.add(0);
        int size=0;
        int count = 0;
        while(!q.isEmpty()){
            size=q.size();
            count++;
            for(int i=0;i<size;i++){
                int n=q.poll();
                for(int j=1;j<=nums[n];j++){
                    if(!set.contains(n+j)){
                        if(n+j==nums.length-1){
                            return count;
                        }
                        set.add(n+j);
                        q.add(n+j);
                    }
                }
            }   
        }
        return 2334;
    }
}

//We can also solve this using DFS but it will explore all possible paths and then give us the answer so BFS is better than DFS
// DFS Time  complexity : exponential
// BFS Time complexity : O(n)

//Optimal Solution
//In this we are maintaining 2 variables currentIndex and nextIndex
//Time Complexity : O(n)
//Space Complexity : O(1)
class Solution {
    public int jump(int[] nums) {
        if(nums.length==0 || nums.length==1){
            return 0;
        }
        int currentIndex=nums[0];
        int nextIndex=nums[0];
        int jump=1;
        for(int i=0;i<nums.length;i++){
            nextIndex=Math.max(nextIndex,i+nums[i]);
            if(i<nums.length-1 && i==currentIndex){
                currentIndex=nextIndex;
                jump++;
            }
        }
        return jump;
    }
}