// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are iterating through the list linearly   
//Space Complexity: O(1) since we are not using any extra space
class Solution {
    public int jump(int[] nums) {
     if(nums == null || nums.length < 2) return 0;
     int curr = nums[0]; int next = nums[0];
     int jump = 1;
     for(int i = 1; i < nums.length; i++){
         next = Math.max(next, i + nums[i]);
         if(i < nums.length - 1 && curr == i){
             curr = next;
             jump++;
         }
     }
     return jump;
    }
}