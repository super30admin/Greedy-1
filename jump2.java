// Time Complexity: O(n) — single pass updating reach windows.
// Space Complexity: O(1) — constant extra variables.

// Maintain a sliding “jump window”: currInt = farthest index reachable with current #jumps, and maxInt = farthest seen so far.
// Iterate i=1..n-1: update maxInt = max(maxInt, i + nums[i]).
// When i == currInt (and not at last index), increment jumps and set currInt = maxInt; return jumps at the end.

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        if(n == 1) return 0;

        int maxInt = nums[0], currInt = nums[0];
        int jumps = 1;

        for(int i=1; i<n; i++){
            maxInt = Math.max(maxInt, i+nums[i]);

            if(i!=n-1 && i == currInt){
                jumps++;
                currInt = maxInt;
            }

           // if(currInt >= n-1) return jumps;
        }

        return jumps;
    }
}
