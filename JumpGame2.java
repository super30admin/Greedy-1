// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int jump(int[] nums) {
        
        if(nums == null || nums.length < 2) return 0;
        
        int current = nums[0];
        int next = nums[0];
        int jumps = 1;
        
        for(int i = 0; i < nums.length; i++) {
           
            next = Math.max(next, i + nums[i]);

            if(current >= nums.length - 1){

                return jumps;
            }
            if(i == current) {
                current = next;
                jumps++;
            }
        }
        
        return -1;
    }
}