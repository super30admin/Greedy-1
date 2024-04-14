// TC: O(n)
// SC: O(1)

// Approach: Keep track of the farthest you can go at any point and
// farthest you can go from the starting index. Whenever you reach the
// current end, increment the jump as this is the farthest you can go
// from the start; the next end will be farthestEnd; which means your
// second jump can take you there and so on.

class JumpGame2 {
    public int jump(int[] nums) {
        int currentEnd = nums[0];
        int farthestEnd = nums[0];
        int res = 0;

        for (int i = 1; i < nums.length; i++) {
            farthestEnd = Math.max(farthestEnd, i + nums[i]);
            if (i == currentEnd || i == nums.length - 1) {
                res++;
                currentEnd = farthestEnd;
            }
        }

        return res;
    }
}