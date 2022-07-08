// Time Complexity :o(N)
// Space Complexity :CONSTANT
// Did this code successfully run on Leetcode :yes


class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        int currInt = nums[0];
        int nextInt = 0;
        int jump = 1;
        for (int i = 1; i < nums.length; i++) {
            nextInt = Math.max(nextInt, i + nums[i]);
            if (i != nums.length - 1 && i == currInt) {
                jump++;
                currInt = nextInt;
                nextInt = 0;
            }

        }
        return jump;
    }
}