
//Time Complexity: O(n)
//Space Complexity: O(1)

//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//We start from the last index and keep updating the target index to the current index 
//if we can reach the target from the current index.
//Finally, if the target index is 0, we can reach the and return true else false.

class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if(n==1)  //base case
            return true;
        int target=n-1;
        for(int i=n-1;i>=0;i--){
            if(i+nums[i]>=target)
                target=i;
        }
        return target==0;
    }
}