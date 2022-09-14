// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Ele   2, 3, 1, 1, 4
//Index 0  1  2  3  4
//Iteration jumps currInterval  nextInterval
// 0          1         2           2
// 1          1         2         max(2, (3+1)) = 4
// 2          1         2         max(4, (1+2)) = 4
//i == currInterval, change currInterval to nextInterval, increment jumps

// 3          2         4         max(4, (1+3)) = 4
// 4          2         4         max(4, (4+4)) = 8

//i==n-1, return jumps

class JumpGame2Greedy {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n < 2) return 0;

        int jumps = 1, currInterval = nums[0], nextInterval = nums[0];
        for(int i = 1; i < n; i++) {
            nextInterval = Math.max(nextInterval, i+nums[i]);

            if(i < n-1 && i == currInterval) {
                jumps++;
                currInterval = nextInterval;
            }
        }
        return jumps;
    }
}