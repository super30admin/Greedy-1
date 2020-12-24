// Time Complexity : O(m^n), where m is the maximum jump you can take at each index And n is the size of the input array
// Space Complexity : O(h), where h is the maximum between size of the array OR the the maximum jump value in the array (recursive stack space)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :

//Three liner approach of your code
//1. Start DFS from the first index, and explore all the indexs you can reach from that index starting from 1 jump to the maximum
        //jumps you can take from that index.
//2. Then continue doing this for all the indexes and whenever your index becomes n-1 or greater (that is from an index you are able to jump
        // to the last index), record the global minimum jumps required to reach the last index
//3. In this problem yo explore all paths fron where you can reach last index And record the minimum number of jumps

// Your code here along with comments explaining your approach

class Solution {
    //variable to maintian the minimum number of jumps to reach the last index
    int min;
    public int jump(int[] nums) {
        min = Integer.MAX_VALUE;
        dfs(nums, 0, 0);
        return min;
    }
    
    private void dfs(int[] nums, int index, int jumps){
        //base
        //reach the last index or beyond, record the golbal minimum jumps
        if(index >= nums.length-1){
            min = Math.min(min, jumps);
            return;
        }
        
        //logic
        for(int i=1; i<=nums[index]; i++){
            //take a jump from 1 to max jump at that index
            dfs(nums, index+i, jumps+1);
        }
    }
}