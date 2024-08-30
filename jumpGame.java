// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length < 2)
            return true;

        int currInt = nums[0];
        int nextInt = nums[0];

        for (int i = 0; i < nums.length; i++) {
            nextInt = Math.max(nextInt, i + nums[i]);
            if (i == currInt && currInt == nextInt && i != nums.length - 1)
                return false;
            if (nextInt >= nums.length - 1)
                return true;
            if (i == currInt)
                currInt = nextInt;
        }

        return nextInt >= nums.length - 1;

    }
}