// Time complexity - O(n)
// Space complexity - O(1)

// Greedy solution

class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length  < 2) return true;
        int n = nums.length;
        int destination = n - 1;
        for(int i = n - 2; i >= 0 ; i--){
            if(nums[i] + i >= destination){
                destination = i;
            }
        }
        if(destination == 0) return true;
        return false;
    }
}
