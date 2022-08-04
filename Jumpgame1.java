//TC:O(n) n is the given array length
//SC:O(1)

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==0 || n==1) return true;
        int target = n-1;
        for(int i= n-2;i>=0;i--){
            if(i+nums[i] >= target) target = i;
        }
        if(target==0) return true;
        else return false;
    }
} 