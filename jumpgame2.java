//Time compl;exity:O(n)
//Space complexity:O(1)

class Solution {
    public int jump(int[] nums) {
      int n = nums.length;
      if (n < 2) {
          return 0;
      }
      int maxPos = nums[0];
      int maxSteps = nums[0];
      int jumps = 1;
      for (int i = 1; i < n; ++i) {
        if (maxSteps < i) {
          jumps++;
          maxSteps = maxPos;
        }
        maxPos = Math.max(maxPos, nums[i] + i);
      }
      return jumps;
    }
  }