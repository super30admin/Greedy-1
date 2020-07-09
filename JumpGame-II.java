//time o(n)
//space o(1)
class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2)
            return 0;
        int jump = 1;
        int curInterval = nums[0];
        int nextInterval = nums[0];
        
        for(int i=0; i<nums.length; i++) {
            nextInterval = Math.max(nextInterval, i+nums[i]);
            if(i<nums.length-1 && i == curInterval) {
                curInterval = nextInterval;
                jump++;
            }
        }
        return jump;
    }
}