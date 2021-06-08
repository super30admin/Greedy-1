// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1){
            return 0;
        }
        int jumps = 0;
        int currInt = 0;
        int nextInt = 0;
        
        for(int i=0;i<nums.length;i++){
            if(i+nums[i] > nextInt){
                nextInt = i + nums[i];
            }
            
            if(i == currInt){
                currInt = nextInt;
                jumps++;
            }
            
            if(currInt >= nums.length - 1){
                break;
            }
        }
        
        return jumps;
    }
}