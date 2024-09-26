// Time Complexity : O(n^n) for DFS; O(n) for Greedy n = no of elements in the array
// Space Complexity : O(1) for both approaches
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// DFS
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) return true;
        return dfs(nums,0);
    }
    
    private boolean dfs(int[] nums, int i) {
        // base
        if(i == nums.length-1) return true;
        // logic
        for(int j=1;j<=nums[i];j++) {
            if(dfs(nums,i+j)) return true;
        }
        return false;
    }
}

// Greedy Approach
// Start from destination. Move backwards, till the index plus the number is greater than or equal to 
// destination coordinates you can reach the destination. Once the condition satisfies, destination is 
// updated to the previous destination that can be reached. If it reaches the source, it means the path is possible.

class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return true;
        int destination = nums.length - 1;
        for(int i=destination;i>=0;i--) { // start from destination
            if(i+nums[i] >= destination) { 
                destination = i;
            }
        }
        return destination == 0;
    }
}