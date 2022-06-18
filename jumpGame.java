TC : O(N)
SC : O(1)
class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null||nums.length==0) return false;
        if(nums.length==1) return true;
        int n = nums.length;
        int curr = n-1;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]>=curr-i)
                curr = i;
        }
        return (curr==0);
    }
}