//Time Complexity:O(n)
//Space Complexity:O(1)
class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length <2) return 0;
        int jumps = 1;
        int curr = nums[0];
        int next = nums[0];
        for(int i = 1; i < nums.length-1; i++){
            next = Math.max(next, nums[i]+i);
            if(i==curr ){
                curr = next;
                jumps++;
            }
        }
        return jumps;
    }
}