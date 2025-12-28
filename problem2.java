// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :still fuzy on the logic

/*
Appraoch

*/
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int nextInter = nums[0];
        int curInter = nums[0];
        int jump = 0;
        for (int i = 0; i < n; i++) {
            nextInter = Math.max(nextInter, nums[i] + i);
            if (i == curInter) {
                jump++;
                curInter = nextInter;
            }
        }
        return jump;
    }
}