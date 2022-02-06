// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// Since we are sure that we will reach the last location, we will traverse till the second last location, since we initialize jumps to 1
// when index reaches curr, we increase the jumps and update curr to next
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int jumps = 1, n = nums.length;
        int curr = nums[0], next = nums[0];

        for (int i=0; i<n-1; i++) {     //stop at second last element since we start jumps with 1
            next = Math.max(next, i+nums[i]);

            if (i == curr) {
                jumps++;
                // update curr with next
                curr = next;
            }
        }

        return jumps;
    }
}