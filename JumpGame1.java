// TC: O(n)
// SC: O(1)
class JumpGame1 {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for(int i = 0;i< nums.length;i++) {
            // I can't reach the index i since my farthest is smaller than i
            if(i > farthest) {
                return false;
            }
            farthest = Math.max(farthest, i+nums[i]);
            if(farthest >= nums.length-1) {
                return true;
            }
        }
        return false;
    }
}