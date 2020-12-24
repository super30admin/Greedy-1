// Time Complexity : O(m^n), where m is the maximum jump you can take at each index And n is the size of the input array
// Space Complexity : O(h), where h is the maximum of size of the array OR the the maximum jump value in the array (recursive stack space)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :

//Three liner approach of your code
//1. Start DFS from the first index, and explore all the indexs you can reach from that index starting from 1 jump to the maximum
        //jumps you can take from that index.
//2. Then continue doing this for all the indexes and whenever your index becomes n-1 (that is from an index you are able to jump
        // to the last index return true), else, even if the maximum jump at that index, didnot reach you to the last index return 
        //false, and explore other indexes
//3. NOTE: we do a function level return here (if your dfs functions evaluates to be true, return true) -> this recursively evaluates 
        //all the remaining calls in the callStack to be true AND we return true to the main function

// Your code here along with comments explaining your approach

class Solution {
    public boolean canJump(int[] nums) {
        //edge case
        if(nums.length == 1) return true;
        
        return dfs(nums, 0);
    }
    
    private boolean dfs(int[] nums, int index){
        //base
        //if you reach the last index, return true
        if(index == nums.length-1) return true;
        
        //logic
        for(int i=1; i<=nums[index]; i++){
            //if previous dfs function call return true, return true (you already reached the last index)
            if(dfs(nums, index+i)) return true;
        }
        //if even the maximum jump at an index can't reach you till last index, return false for that index
        return false;
    }
}