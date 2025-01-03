// Approach : Greedy - Try to optimize the nextInterval at every step
// Time : O(n)
// Space : O(1)
class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length <=1) return 0;
        int jumps = 1;
        int currInterval = nums[0];
        int nextInterval = nums[0];
        List<Integer> path = new ArrayList<>();
        for(int i =1;i<nums.length;i++){
            nextInterval = Math.max(nextInterval,nums[i]+i);
            if(currInterval == i && i!= nums.length-1 ){
                currInterval = nextInterval;
                jumps++;
            }

            if(currInterval >=nums.length-1) break;

        }
        return jumps;
    }
}