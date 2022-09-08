// TC: O(n)
// SC: O(1)

class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int d=nums[n-1];
        
        for(int i=n-1;i>=0;i--){
            if(nums[i]+i>=d){
                d=i;
            }
        }
        
        return d==0;
    }
}
