//Time complexity:O(n)
//Space complexity:O(1)

class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length==0){
            return true;
        }
        int n=nums.length;
        int dest=n-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]+i>=dest){
                dest=i;
            }
        }
        if(dest==0){
            return true;
        }
        return false;
    }
}