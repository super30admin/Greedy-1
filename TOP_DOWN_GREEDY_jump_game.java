// Time Complexity :O(n), where n is the size of the array
// Space Complexity :O(1), no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner approach of your code in plain english
//1. We can even do a Top-down approach (Intuition -> for reach from start to end, you can start from the start index and can check 
        //if you can atleast reach the next index, so on till the last index)
//2. Maintain a reachable index starting at 0. Start the traversing the array from the 0th index, and check if reachable is greater
        //than or equal to the current index (meaning you can atleast reach this index).
        //If yes, reassign the reachable to the maximum of the current reachable and the index the current jump can take you to.
        //If no return false, Meaning if you can't even reach the current index with maximum possible jumps, then you can't reach 
                //the last index too
//3. If the for-loop finishes, meaning you can reach the last index, so return true
// Your code here along with comments explaining your approach

class Solution {
    public boolean canJump(int[] nums) {
        //edge case
        if(nums.length == 1) return true;
        int n = nums.length;
        //variable to hold the current destination
        int reachable =0; //top-down approach
        
        //itervate over the array and check if you can reach atleast the next index
        for(int i= 0; i<n; i++){
            //check if you can reach the current index
            if(reachable < i){
                //return false if you can't
                return false;
            }
            //reassign reachable to the maximum between the current reachable and the index current jump can reach
            reachable = Math.max(reachable, i+nums[i]);
        }
        //if you reach here, that means you can successfully reach next index, till the last index, so return true
        return true;
    }
}