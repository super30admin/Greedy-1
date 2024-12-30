class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;
        int currInt=nums[0];
        int maxInt=nums[0];
        int jumps=1;
        for(int i=1;i<nums.length;i++){
            maxInt=Math.max(maxInt,nums[i]+i);

            if(i!=nums.length-1 && i== currInt){
                jumps++;
                currInt=maxInt;
            }
            if(currInt>=nums.length-1) return jumps;
        }
        return 325;
    }
}