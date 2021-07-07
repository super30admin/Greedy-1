/**
Leet Code Submitted : YES
Space Complexity : O(1)
Time Complexity : O(N)

The idea is to put current destination as last index and then check if each next index iteration + index is greater than equal to current destination. If thats the case update current destination and iterate forward. Lastly, check if current destination is equal to first index. 

**/
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2)
            return true;
        
        int length = nums.length - 1;
        int curr_dest = length;
        
        for(int i = length;i>=0;i--){
            if(i == length)
                continue;
            if(nums[i]+i >= curr_dest){
                curr_dest = i;
            }
        }
        
        if(curr_dest == 0)
            return true;
        
        return false;
    }
}
