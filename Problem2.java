// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int jump(int[] nums) {
        if(nums==null || nums.length<2)
            return 0;
        int nextjump=nums[0];
        int currjump=nums[0];
        int jump=1;
        for(int i=1;i<nums.length-1;i++){
            if(i+nums[i]>currjump){ //check the max index that can be reached at each step
                currjump=i+nums[i];
            }
            if(i==nextjump){
                nextjump=currjump;//update nextjump oly if we reached the max index reachable by currjump
                jump++;
            }
            if(nextjump>=nums.length-1){
                break;
            }
        }
        
        return jump;
    }
}