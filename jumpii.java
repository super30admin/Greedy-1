// Time Complexity : 0(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){
            return 0;
        }
        int jumps = 0;
        int interval = 0;
        int max = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            max = Math.max(i + nums[i], max);
            if(i < n- 1 && interval == i){ // reached last element of current interval.
                interval = max;
                jumps++;
            }
        }
        return jumps;
    }
}