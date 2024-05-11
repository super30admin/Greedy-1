//TimeComplexity:O(n)
//SpaceComplexity:O(1)


class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
        int currentInterval = nums[0];
        int nextInterval = nums[0];
        int jumpsCount = 1;
        for(int i =0; i<nums.length;i++) {
            nextInterval = Math.max(nextInterval, i+nums[i]);
            if(i == currentInterval && i!= nums.length-1) {
                currentInterval = nextInterval;
                 jumpsCount = jumpsCount+1;
            }
        }
        return jumpsCount;
    }
}