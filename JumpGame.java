//TC = O(n)
//SC = O(1)
//Here we are using greedy approach.
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) return true;

        int target = nums.length-1;
        for(int i= nums.length-2; i>=0; i--){
            if(i+nums[i] >= target){
                target = i;
            }
        }
    return target == 0;
    }
}