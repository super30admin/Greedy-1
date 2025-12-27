// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : We follow greedy approach and find the minimum jumps to reach or cross the end index of the array. The idea is to find the
// farthest possible jump in each interval and continue as we are guaranteed that we reach the end of array. We set the current interval
// and next interval to intial jump range and calculate the farthest jump and capture in next interval. Once i reaches current interval, it
// means one jump is complete so we increment jumps and update the current interval to next interval and continue parsing until end of array.

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }
        int currInt = nums[0]; //current interval
        int nextInt = nums[0]; //next interval
        int jumps = 1;
        for (int i = 0; i < n; i++) {
            nextInt = Math.max(nextInt, i + nums[i]); //update next interval
            if (i == currInt) { //one jump is complete
                if (i != n - 1) { //when at end of array
                    jumps++; //increment jump
                }
                currInt = nextInt; //uodate current interval
            }
        }
        return jumps;
    }
}