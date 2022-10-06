//TC : O(n)
//SC : O(1)

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;
        int target = nums.length-1;
        
        for(int i=n-2;i>=0;i--){
            if(i+nums[i] >= target){
                target = i;
                if(target == 0) return true;
            }
        }
        return false;
    }
}
