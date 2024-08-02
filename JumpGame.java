//Approach - Greedy, Time - O(n), Space - O(1)
class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return true;
        }

        int n = nums.length;
        int destination = n-1;

        for(int i=n-2; i>=0; i--) {
            if(nums[i] + i >= destination) {
                destination = i;
            }
        }

        return destination == 0;
    }
}
