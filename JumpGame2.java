// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//Start from the end, and populate the dpArray with min steps required to jump to the next step


class Solution {
    public int jump(int[] nums) {

        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dpArray = new int[n];
        dpArray[n-1] = 0;

        for(int i = n-2; i >= 0; i--) {

            int maxJump = nums[i];
            int j = 1;
            int curMin = 1000000;
            while(j <= maxJump && (i+j) < n) {
                curMin = Math.min(curMin, dpArray[i+j] + 1);
                j++;
            }
            dpArray[i] = curMin;
        }

        return dpArray[0];

    }
}
