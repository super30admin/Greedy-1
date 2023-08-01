//Time Complexity: O(N)
//Space Complexity: O(1)

class Solution {
    public boolean canJump(int[] nums) {
     int boundary = 0;
     for(int i =0;i<=boundary;i++) {
         boundary = Math.max(boundary,i+nums[i]);
         if(boundary >=nums.length-1)
         return true;
    } 
    return false;
    }
}