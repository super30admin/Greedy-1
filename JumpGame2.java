// This solution uses a greedy approach to jump max possible width. We keep that interval to proceed to next element
// At each element, we check if the max range is extended. if its extended then we update the interval
// Otherwise we just keep travershing
// Jumps are incremented only when we reach the max number of the interval
class Solution {
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int max = nums[0], currInt = nums[0], jumps = 1;

        for(int i=1;i<nums.length;i++) {
            max = Math.max(max, i+nums[i]);

            if(i!=nums.length-1 && i==currInt) {
                currInt = max;
                jumps++;
            }
        }
        return jumps;
    }
}
