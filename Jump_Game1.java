// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null )
            return true;
        int n = nums.length;
        // Whether we will be able to reach the destination which is the length of the strng.
        int destination = n-1;
        
        //Start from the end and check if there is any path which is not reachable
        
        for(int i = destination-1; i>=0; i--){
            if(nums[i] + i >= destination)  // Desitination is the last index value
                destination = i;            // If the prev value can reach the destination, then set the prev value as destination 
                                            // and evaluate till it reaches 0. If it successfully reached 0 then return true.
           
            System.out.println(destination);
        }
        return destination <= 0;
    }
}
