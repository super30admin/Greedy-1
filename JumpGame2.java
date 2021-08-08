// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2)
            return 0;
        int jumps = 1;
        int cur = nums[0];
        int next = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(i == nums.length - 1)
                return jumps;
            next = Math.max(next, nums[i] + i);
            if(i >= cur){
                jumps++;
                cur  = next;
            }
        }
        return jumps;
    }
}