class Solution {//Time of O(n) and space of O(1)
    public boolean canJump(int[] nums) {
        //Base case 
        if(nums == null || nums.length <2)
            return true;
        
        int destination = nums.length-1;
        for(int i = destination-1 ; i>=0;i--){
            if(i+nums[i]>= destination){
                destination = i;
            }
        }
        return destination == 0 ;
    }
}