// TC - O(n), SC - O(1)

// LC - 55

class Solution {
    public boolean canJump(int[] nums) {
		// Sanity check
        if(nums == null || nums.length == 0){
            return true;
        }
		// we calculate from ending, update dest if i+nums[i] >= dest to current i. if this is true, we are sure we can reach dest from that i, return dest == 0
        int n = nums.length;
        int dest = n-1;
        for(int i=n-2; i>=0; i--){
            if(i + nums[i] >= dest){
                dest = i;
            }
        }
        return dest == 0;
    }
}

// public class Solution {
//     public boolean canJumpFromPosition(int position, int[] nums) {
//         if (position == nums.length - 1) {
//             return true;
//         }

//         int furthestJump = Math.min(position + nums[position], nums.length - 1);
//         for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
//             if (canJumpFromPosition(nextPosition, nums)) {
//                 return true;
//             }
//         }

//         return false;
//     }

//     public boolean canJump(int[] nums) {
//         return canJumpFromPosition(0, nums);
//     }
// }

// class Solution {
//     public boolean canJump(int[] nums) {
//         int reachMax = 0;
//         for(int i=0; i<nums.length; i++){
//             if(reachMax < i){
//                 return false;
//             }
//             reachMax = Math.max(reachMax, i+nums[i]);
//         }
//         if(reachMax >= nums.length-1){
//             return true;
//         }
//         return false;
//     }
// }