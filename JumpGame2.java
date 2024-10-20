// TC: O(n)
// SC: O(1)
class JumpGame2{
    public int jump(int[] nums) {
        int farthest = 0;
        int count = 0 ;
        int currentJumpEnd = 0;
        for(int i =0;i<nums.length-1;i++) {
            farthest = Math.max(farthest, i+nums[i]);
            if(i == currentJumpEnd) {
                count++;
                currentJumpEnd = farthest; 
                if(currentJumpEnd >= nums.length-1) {
                    return count;
                }
            }
        }
        return count;
    }
}