//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this : no
class Solution {
    public int jump(int[] nums) {
        
        if(nums.length == 0 || nums.length == 1){
            
            return 0;
        }
        
        int jump = 1;
        int curr = nums[0];
        int next = nums[0];
        
        for(int i = 1; i < nums.length; i ++){
            
            next = Math.max(next, nums[i] + i);
            
            if(i < nums.length -1 && i == curr){
                
                curr = next;
                jump ++;
            }
        }
        return jump;
    }
}