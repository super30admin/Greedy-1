// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//Start from the end, and populate the boolean array
//If there is a path from i -> next element that we can jump from i, (dpArray[i+jump] == true) then update dpArray[i] to true
// For the last element, we can always jump to itself, so we Initialize  the last element to true

class Solution {
    public boolean canJump(int[] nums) {


        int n = nums.length;
        boolean[] dpArray = new boolean[n];
        dpArray[n-1] = true;

        for(int i = n-2; i >= 0; i--) {

            int maxJump = nums[i];
            int j = 1;
            while(j <= maxJump && (i+j) < n) {

                if(dpArray[i+j] == true) {
                    dpArray[i] = true;
                    break;
                }
                j++;
            }
        }

        return dpArray[0];
    }
}
