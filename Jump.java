// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Jump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int target = n-1;
        for(int i=n-2;i>=0;i--){
            if(i+nums[i]>=target){
                target = i;
            }
        }

        return target == 0;
    }
}