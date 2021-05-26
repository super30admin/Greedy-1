//Greedy approach
//Time cOmplexity :O(n)
//Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Your code here along with comments explaining your approach
class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null && nums.length<2){
            return true;
        }
        //start from the end of the list
        int destination = nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            //check if the current element can reach each destination
            if(nums[i] + i >= destination){
                //update the new destination
                destination = i;
                //each new destination indicates that so far the elements from end is reachable to alst index
            }
        }
        //if the jump can be made to the last index then return true
        return destination==0;
    }
}