// TC: O(N)
// SC: O(1) 
// Did it run successfully on Leetcode? : Yes
class Solution {
 public int jump(int[] nums) {
     int n = nums.length;
     if(nums == null || nums.length == 0)
            return 0;
     if (n < 2) 
        return 0;    
     int jumps = 1;
     int curr_interval = nums[0];
     int next_interval = nums[0];
     for (int i = 1; i < n; i++)
     {
         next_interval = Math.max(next_interval, i + nums[i]);
         if (i < nums.length-1 && curr_interval == i)
         {
             curr_interval = next_interval;
             jumps++;
         }
     }
     return jumps; 
   }
}
