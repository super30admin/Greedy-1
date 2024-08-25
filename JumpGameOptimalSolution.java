// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Use destination variable holding the last index. Then run a for loop from the 2nd last element and check if the current index plus the element on that index is greater than destination, update the detsination to current index. Lastly, check if destination has reached to index 0 return true else return  false
 */
class Solution {
    public boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0 || nums.length == 1) {
            return true;
        }

        int destination =  nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--){

            if(nums[i] + i >= destination){
                destination = i;
            }
        }

        return destination == 0 ? true : false;
    }
}