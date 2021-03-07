// Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes

class JumpGame {
    public boolean canJump(int[] nums) {

        int destination = nums.length - 1;
        //start iterating from back
        for(int i = nums.length - 2; i>=0; i--){
            //see if we can reach destination by adding nums[i] to current index
            //that is we can jump from current index to destination index
            if(i + nums[i] >= destination){
                //if so update destination to current index
                //to see if we can reach the current index
                destination = i;
            }
        }

        //if finally we are able to reach index 0 then return true else false
        return destination == 0;
    }
}