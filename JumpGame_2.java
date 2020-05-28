// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int jump(int[] nums) {
        // edge
        if(nums == null || nums.length < 2) return 0;
        int nextInt = nums[0]; int currInt = nums[0]; int jumps = 1;
        int n = nums.length;
        for(int i = 1; i < n; i++){
            nextInt = Math.max(nextInt, i+nums[i]);
            if(i < n - 1 && currInt == i){
                System.out.println(i);
                jumps++; currInt = nextInt;
            }
        }
        return jumps;
    }
}
