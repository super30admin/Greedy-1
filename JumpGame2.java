// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int jump(int[] nums) {
        
      if(nums == null || nums.length <= 1)
      {
        return 0;
      }
      
      int jumps = 0;
      int currInterval = 0;
      int nextInterval = 0;
      
      for(int i=0;i<nums.length;i++)
      {
        if(i + nums[i] > nextInterval)
        {
          nextInterval = i + nums[i];
        }
        //we have exhausted the jumps
        if(i == currInterval)
        {
          currInterval = nextInterval;
          jumps++;
        }
        //we can reach our destination
        if(currInterval >= nums.length -1)
        {
          break;
        }
      }
      return jumps;
    }
}