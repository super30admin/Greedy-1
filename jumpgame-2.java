TC:O(n) - n no.of elements in a array
SC:O(1)

class Solution {
    public int jump(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return 0;
        int curidx = nums[0];
        int nextidx = nums[0];
       
        int jumps=1;
        for(int i=1;i<nums.length;i++){
            nextidx = Math.max(nextidx,i+nums[i]);
            if(i!=nums.length-1 && i==curidx){
                curidx = nextidx;
                jumps++;
            }
        }
        return jumps;
    }
}