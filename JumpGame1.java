// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//code 4 - Greedy

class Solution {
    public boolean canJump(int[] nums) {

        int n = nums.length;
        int destination = n-1; //last index

        //we go in reverse and check if from each i we can reach the current index
        for(int i=n-2; i>=0; i--) {

            //if from current i, current destination is reachable
            if(i + nums[i] >= destination)
                destination = i; //current i becomes new destination
        }

        //if going backwards we reach the starting point, we return true
        return (destination == 0);

    }
}
