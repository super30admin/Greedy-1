class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n<2) return 0;
        int maxint=nums[0],currint=0;
        int jumps=0;
        for(int i=0;i<n;i++){
            maxint=Math.max(maxint,i+nums[i]);
            if(i==currint){
                jumps++;
                currint=maxint;
            }
            if(currint>=n-1) return jumps;
        }
        return -1;
    }
}
