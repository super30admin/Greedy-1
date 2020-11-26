// Time Complexity : not clear on how to calculate
// Space Complexity : O(n), recursion stack
// Did this code successfully run on Leetcode : 74/75 passed, TLE
// Any problem you faced while coding this : exiting when a solution is found

// Your code here along with comments explaining your approach
// clip elements to arr.length-1, greedily take max step and proceed
// if reached end idx, mark reached
// on successive calls if reached is true just return

class Solution {
    int[] arr;
    boolean reachable = false;
    
    public boolean canJump(int[] nums) {
        this.arr = nums;
        
        for(int i=0; i<arr.length; i++){
            arr[i] = Math.min(arr[i], arr.length-1);
        }
        
        helper(0);
        return reachable;
    }
    
    private void helper(int idx){
        if(reachable==true)
            return;
        
        if(idx==arr.length-1){
            reachable = true;
            return;
        }
        
        for(int step=arr[idx]; step>=1; step--){
            if(idx+step<=arr.length-1){
                helper(idx+step);    
            }
        }
    }
}