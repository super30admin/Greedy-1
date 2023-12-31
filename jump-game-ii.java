// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int jump(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return 0;
        int curmax = nums[0];
        int nextmax = nums[0];
        int jumps = 1;
        for(int i = 1; i < nums.length; i++)
        {
            nextmax = (i + nums[i] > nextmax) ? (i + nums[i]) : nextmax;
            if(curmax == i && i != nums.length - 1)
            {
                curmax = nextmax;
                jumps++;
            }
            if(curmax >= nums.length - 1)
                break;
        }
        return jumps;
    }
}