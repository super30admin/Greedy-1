// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        // leftpass
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        // rightpass
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int totalmincandies = 0;
        for (int candy : candies) {
            totalmincandies = totalmincandies + candy;
        }
        return totalmincandies;
    }
}

//
class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }

        }
        return goal == 0;
    }
}

//
class Solution {
    public int jump(int[] nums) {
        // 'destination' is the last index, which is our target.
        int destination = nums.length - 1;

        // Base case: If the array has only one element, we are already there.
        if (nums.length == 1) {
            return 0;
        }

        int totalJumps = 0;
        // 'lastJumpIdx' is the boundary of our current jump.
        int lastJumpIdx = 0;
        // 'coverage' is the farthest we can reach from our current window.
        int coverage = 0;

        // We walk through the array to find the best spots to jump from.
        for (int i = 0; i < nums.length; i++) {
            // Update coverage to find the farthest possible reach from our current spot.
            coverage = Math.max(coverage, i + nums[i]);

            // When our walker 'i' reaches the boundary of our last jump...
            if (i == lastJumpIdx) {
                // It's time to take the next jump.
                totalJumps++;
                // Our new boundary becomes the best coverage we found.
                lastJumpIdx = coverage;

                // Check if our new coverage has reached the end.
                if (coverage >= destination) {
                    return totalJumps;
                }
            }
        }

        return totalJumps;
    }
}
