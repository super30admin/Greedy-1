//time complexity:O(n)
//space complexity:O(1)


class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        int n=nums.length;
        //int dest=n-1;
        int reach=0;
        for(int i=0;i<n;i++)
        {
            if(i>reach) return false;
            reach=Math.max(reach,nums[i]+i);
        }
        return true;
    }
}
