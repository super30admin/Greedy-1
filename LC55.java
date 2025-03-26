// Time Complexity: O(n)
// Space Complexity: O(1)


class LC55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int dest = n-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]+i>=dest) dest=i;
        }
        return dest == 0;
    }
}