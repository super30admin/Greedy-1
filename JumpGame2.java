// TC - O(n), SC - O(1)

// LC - 45
class Solution {
    public int jump(int[] nums) {
		// Initialize jumps, ,currJumpEnd, farthest to 0
        int jumps = 0;
        int currentJumpEnd = 0;
        int farthest = 0;
		// Iterate over nums array
        for(int i=0; i<nums.length-1; i++){
			// calculate farthest, max of farthest and i + nums[i]
            farthest = Math.max(farthest, i+nums[i]);
			// if is currentJumpEnd// increment jumps and update currentJumpEnd to farthest
            if(i == currentJumpEnd){
                jumps++;
                currentJumpEnd = farthest;
            }
        }
        return jumps;
    }
}


// class Solution {
//     public int jump(int[] nums) {
//         if(nums == null || nums.length <= 1){
//             return 0;
//         }
        
//         int jumps = 0;
//         int currInterval = 0;
//         int nextInterval = 0;
        
//         for(int i=0; i<nums.length; i++){
//             if(i + nums[i] > nextInterval){
//                 nextInterval = i + nums[i];
//             }
            
//             if(i == currInterval){
//                 currInterval = nextInterval;
//                 jumps++;
//             }
            
//             if(currInterval >= nums.length-1){
//                 break;
//             }
//         }
//         return jumps;
//     }
// }
