// O(n) time: traverse array of n elements once
// O(1) space

class Solution {
    public int jump(int[] nums) {
        int jumps = 0; // number of jumps
        int currJumpEnd = 0; // end of current jump (of the farthest)
        int farthest = 0; // mark the fartest we can jump to
        
        for (int i = 0; i < nums.length - 1; i++){
            farthest = Math.max(farthest, i + nums[i]);
            
            if (i == currJumpEnd){
                jumps++;
                currJumpEnd = farthest;
            }
        }
        return jumps;
    }
}