//TC -O(n)
//SC -O(1)
//LC -55
class Solution {
    public boolean canJump(int[] nums) {
        int dest = nums.length-1;
        
        for(int i=nums.length-2;i>=0;i--){
            int idx = i+nums[i];
            if(idx>=dest){
                dest = i;
            }
        }
        
        if(dest==0) return true;
        
        return false;
    }
}