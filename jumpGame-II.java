// Time Complexity : o(n)
// Space Complexity : 1
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 45


class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        
        int jump = 1; 
        
        int curr = nums[0]; 
        int cover = nums[0];
        
        
        for(int i = 1 ; i < nums.length ; i++){
            cover = Math.max(cover, i + nums[i]);
            if(curr != nums.length-1 && curr == i){
                curr = cover;
                jump++;
            }
        }
        
        return jump;
    }
}