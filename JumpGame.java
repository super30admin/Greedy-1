//TC : O(n) , where n is length of array
//SC : O(1)
class Solution {
    public boolean canJump(int[] nums) {
        
        if(nums == null || nums.length <2)
            return true;
        
        int destination = nums.length-1;
        
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]+i >= destination)
                destination = i;
        }
        
        return destination==0;
        
    }
}