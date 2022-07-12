// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int currInterval = nums[0];
        int nextInterval = nums[0];
        
        int jumps=1;
        
        if(n<2){
            return 0;
        }
        for(int i=1;i<n;i++){
            nextInterval = Math.max(nextInterval, nums[i]+i);
            
            if(i!=n-1 && i==currInterval){
                jumps++;
                currInterval = nextInterval;
            }
        }
        
        return jumps;
    }
}
