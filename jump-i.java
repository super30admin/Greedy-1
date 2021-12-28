// Memoization

// Time - O(n^2)
// Space - O(n) // Stack

// class Solution {
//     public boolean canJump(int[] nums) {
//         int[] dp = new int[nums.length];
//         return helper(0, nums, dp);
//     }
    
//     private boolean helper(int i, int[] nums, int[] dp){
        
//         if(i >= nums.length -1){
//             return true;
//         }
        
//         if(dp[i] != 0){
//             return dp[i] == 1; 
//         }
        
//         for(int j = 1; j <= nums[i]; j++ ){
//             boolean result = helper(i+j, nums, dp);
//             if(result == true){
//                 dp[i] = 1;
//                 return true;
//             }
//         }
        
//         dp[i] = -1;
//         return false;
//     }
// }


// Greedy
//Time - O(n^2)
//Space - O(n)


class Solution {
    public boolean canJump(int[] nums) {
        int destination = nums.length - 1;
        
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] >= destination - i){
                destination = i;
            }
        }
        return destination == 0;
    }
}