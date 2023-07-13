## Problem1 Jump Game (https://leetcode.com/problems/jump-game/)

// Time Complexity : 0(n) where n is the length of the input array nums. The for loop iterates over the array once
// Space Complexity : 0(1) because the solution uses a constant amount of extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return true;
        }
        int n = nums.length;
        int destination = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= destination) {
                destination = i;
            }
        }
        return destination == 0;      
    }
}

## Problem2 Jump Game II (https://leetcode.com/problems/jump-game-ii/)

// Time Complexity : 0(n) where n is the length of the input array nums. The for loop iterates over the array once
// Space Complexity : 0(1) because the solution uses a constant amount of extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }
        int jumps = 1;
        int currInterval = nums[0];
        int nextInterval = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nextInterval = Math.max(nextInterval, nums[i] + i);
            if (i < nums.length - 1 && i == currInterval) {
                jumps++;
                currInterval = nextInterval;
            }
        }
        return jumps;       
    }
}

## Problem3 Candy (https://leetcode.com/problems/candy/)

// Time Complexity : 0(n) where n is the length of the input array ratings. The solution iterates over the array twice. Once from left to right and once from right to left
// Space Complexity : 0(n) The solution uses an additional array, candies, of size n to store the number of candies given to each child.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int candy(int[] ratings) {
        if (ratings == null ||ratings.length == 0) {
            return 0;
        }
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int total = candies[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            total = total + candies[i];
        }
        return total;
    }
}


