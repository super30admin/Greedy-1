class Solution {
    public boolean canJump(int[] nums) {
        //2,3,1,0,4
        
        //If we go by common sense, we can see that if the second last element does not make you reach the destination, nothing can.
        //We just keep on looking for points that make you reach to the last point.
        //if we find such a point then we find points which connect to that point.
        
        int reach_end = nums.length - 1;
        
        for(int i = nums.length - 2; i >= 0 ; i--){
            
            if(i + nums[i] >= reach_end){
                reach_end = i;
            }
            
        }
        
        if(reach_end == 0){
            
            return true;
            
        }
        
        return false;
    }
}