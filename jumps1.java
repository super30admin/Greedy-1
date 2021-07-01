class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return true;
        int n = nums.length - 1;
        int dest = n; 
        
        if(dest == 0) return true;    
        for(int i = n - 1; i >= 0; i--){
            if(nums[i] + i >= dest){
                dest = i;
            }
            if(dest == 0) return true;
        }
        if(dest != 0) return false;
        return true;
    }
}
