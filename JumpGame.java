public class JumpGame {
    // TC : O(n)
    // SC : O(1)
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;

        int n = nums.length;

        // Instead of starting from 0th index, we'll make sub problems
        // we'll check whether the last position is reachable from its previous position , and so on up to the 0th index
        int destination = n - 1;
        for(int i=n-2; i >=0; i--) {
            if(i + nums[i] >= destination){
                destination = i;
            }
        }

        return destination == 0;
    }
}
