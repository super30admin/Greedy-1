//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this : no
class Solution {
    public boolean canJump(int[] nums) {
        
        if(nums.length == 0 || nums.length == 1){
            
            return true;
        }
        
        int n = nums.length;
        int start = n - 2;
        int destination = n - 1;
        
        for(int i = start; i >= 0; i --){
            
            if(i + nums[i] >= destination){
                
                destination = i;
                start = i - 1;
            }
            
             if(destination == 0){
            
            return true;
        }
            
           
        }
        //System.out.print(start);
       
        return false;
    }
}