//Time Complexity :O(n)
//Space Complexity  :O(1)

class Solution {
    public boolean canJump(int[] nums) {
        
      if(nums.length == 1)
          return true;
        
     int maxPosition = nums[0];
        
     for(int i = 1 ; i < nums.length;i++){
         
         if(maxPosition < i)
             return -1; 
         maxPosition
         maxPosition = Math.max(maxPosition, nums[i]+i);
         
     }   
        
     
        
     return true;   
}
}
