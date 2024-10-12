class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==1) return true;
        int csl = nums[0];
        for(int i=1;i<n;i++){
            if(csl == 0) return false;

            csl = Math.max(csl-1,nums[i]);

            
            if(csl >= n-i-1) return true;
        }
        

        return false;
    }
}