//TC : O(n) , n - length of nums array
//SC : O(1)
class Solution {
    public int jump(int[] nums) {
        
        if(nums == null || nums.length < 2)return 0;
        
        int nextInterval = nums[0],currInterval = nums[0];
        int jumps = 1;
        
        for(int i=1;i<nums.length;i++){
            nextInterval = Math.max(nextInterval,nums[i]+i);
            if(i < nums.length-1 && currInterval == i){
                jumps++;
                currInterval = nextInterval;
            }
        }
        
        return jumps;
        
    }
}