// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class jumpGameOne {
    public boolean canJump(int[] nums) {
        if(nums.length == 0 || nums == null) return false;
        
        int n = nums.length - 1;
        
        for(int i = n; i >= 0; i--){
            if(i + nums[i] >= n)
                n = i;
        }
        return n == 0;
    }
}
