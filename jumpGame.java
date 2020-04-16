// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution


// Your code here along with comments explaining your approach
//start from the back to check whether you can reach the destination.
//If yes, then update the destination

class Solution {
    //T: O(N)
    //S: O(1)
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return true;
        
        int destination = nums.length -1;
        
        for(int i=destination-1; i>=0; i--){
            if(i+ nums[i] >= destination){
                destination = i;//update destination whenever above criteria is matched
            }
        }
        
        //final destination should be 0
        return destination == 0;
    }
}
