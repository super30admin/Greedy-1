/**
LeetCode Submitted : YES
Space Complexity : O(1)
Time Complexity : O(N)

The idea is to have currMaxJump and currIndex to see how far jump can be made from each position and based on that we pick the index with the maximum jump till we reach end of the index.
So, for each change in index of the max Jump we increase the num Jumps till we reach end of the array.

**/
class Solution {
    public int jump(int[] nums) {
        
        if(nums == null || nums.length < 2)
            return 0;
        
        
        int currMaxJump = nums[0];
        int currIndex = nums[0];
        int numJumps = 1;
        
        for(int i = 1; i< nums.length && currIndex < nums.length;i++){
            if(i+nums[i] >= currMaxJump){
                currMaxJump = i+nums[i];
            }
            
            if(i<nums.length -1 && i>=currIndex){
                currIndex = currMaxJump;
                numJumps++;
            }
            
        }
        
        return numJumps;
    }
}
