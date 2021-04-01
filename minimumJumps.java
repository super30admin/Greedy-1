// Time complexity - O(n)
// space complexity - O(1) - constant
// Works on leetcode

class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){
            return 0;
        }
        
        int jumps = 1;
        int currInt = nums[0];
        int nextInt = nums[0];
        
        for(int i=1;i<nums.length-1;i++){
            if(i + nums[i] > nextInt){
                nextInt = i + nums[i];
            }
            if(i==currInt){
                currInt = nextInt;
                jumps = jumps + 1;
            }
            if(currInt >= nums.length - 1){
                break;
            }
        }
        return jumps;
    }
}
