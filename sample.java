// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return true;
        }
        int lastPosition = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i + nums[i] >= lastPosition) {
                lastPosition = i;
            }
        }
        return lastPosition == 0;
    }
}


// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) {
            return 0;
        }
        int jumps = 1;
        int current = nums[0];
        int next = nums[0];
        for(int i = 1; i < nums.length; i++) {
            next = Math.max(next, nums[i] + i);
            if(i < nums.length-1 && i == current) {
                jumps++;
                current = next;
            }
        }
        return jumps;
    }
}


// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for(int i = 1; i < candies.length; i++) {
            if(ratings[i-1] < ratings[i]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        for(int i = candies.length - 2; i >= 0; i--) {
            if(ratings[i+1] < ratings[i]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }
        int minCandies = 0;
        for(int i = 0 ; i < candies.length; i++) {
            minCandies += candies[i]; 
        }
        return minCandies;
    }
}
