// Time Complexity : O(n) where n is the length of the array nums
// Space Complexity : O(1) where n is the length of the array nums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class jumpGame2 {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int nextInt = nums[0], currInt = nums[0], jumps = 1;
        for (int i = 1; i < nums.length; i++) {
            nextInt = Math.max(nextInt, i + nums[i]);
            if (i < nums.length - 1 && currInt == i) {
                jumps++;
                currInt = nextInt;
            }
        }
        return jumps;
    }
}