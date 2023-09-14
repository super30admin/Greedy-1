// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2) return 0;
        int currInt = nums[0];
        int nextInt = nums[0];
        int jumps = 1;
        for(int i=1; i<nums.length; i++){
            nextInt = Math.max(nextInt, i+nums[i]);

            if(i != nums.length-1 && i==currInt){
                currInt = nextInt;
                jumps++;
            }
        }

        return jumps;
    }
}