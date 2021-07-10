// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int jump(int[] nums) {
    if(nums.length==0 || nums.length ==1) return 0;
    int jump = 1;
    int currentInterval = nums[0];
    int nextInterval = nums[0];
    for(int i =0; i <nums.length;i++)
    {
        nextInterval = Math.max(nextInterval,i + nums[i]);
        if(i < nums.length-1 && i == currentInterval)
        {
            currentInterval = nextInterval;
            jump++;
        }
    }
        return jump;
    }
}