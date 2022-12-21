class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int m =0, i =0;

        while(i<=m && m<n-1){
            m = Math.max(m, i+nums[i]);
            ++i;
        }

        return m>=n-1;
    }
}
//tc=O(n)
//sc=O(1)
