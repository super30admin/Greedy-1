// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) {
            return 0;
        }
        
        //we start from 1st index, so consider one jump taken 0 -> 1
        int jumps = 1;
        
        //current interval = all elements we can reach from current index value
        int currInterval = nums[0];
        
        //next interval is max index we can reach by going through all elements in current 
        //interval, i.e. maximize the reach from the current interval
        int nextInterval = nums[0];
        
        for(int i=1; i< nums.length; i++) {
            
            //best next interval
            nextInterval = Math.max(nextInterval, i+nums[i]);
            
            //if i is within bounds and i reaches currInterval, change currInterval
            // since we made choice of best element, we took one jump, increase jump count
            if(i < nums.length-1 && i == currInterval) {
                currInterval = nextInterval;
                jumps++;
            }
        }
        
        return jumps;
        
    }
}