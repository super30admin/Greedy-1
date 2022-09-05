//Time Complexity- O(n)
//Space Complexity - O(1)
//Sucessfully ran on leetcode

class Solution {
 public int jump(int[] nums) {
     
     if(nums.length < 2 ) return 0;
     
     int currInterval = nums[0];
     int nextInterval = nums[0];
     int jumps = 1;
     int n = nums.length;
     
     for(int i = 1 ;i < n ; i++){
         
         nextInterval = Math.max(nextInterval , i + nums[i]);
         
         if(currInterval == i && i < n-1 ){
             jumps ++;
             currInterval = nextInterval;
             
         }
     }
     return jumps;
 }
}