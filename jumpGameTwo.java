// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class jumpGameTwo {
    public int jump(int[] nums) {
        if(nums.length == 0 || nums == null) return -1;
        
        int n = nums.length - 1;
        int jumpCount = 0;
        int curr = 0;
        int highestJump = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            highestJump = Math.max(highestJump, i + nums[i]);
            
            if(i == curr){
                jumpCount++;
                curr = highestJump;
            }
        }
        
        return jumpCount;
    }
}
