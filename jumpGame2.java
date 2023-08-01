//Time Complexity: O(N + N)
//Space Complexity: O(1)

class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int curr = nums[0];
        if (curr >= nums.length - 1) return 1;
        int count = 0, idx = 0;
        while (idx < nums.length - 1) {
            int maxReach = nums[idx] + idx, maxIdx = idx;
            int tempSum = maxReach;
            for (int i = idx + 1; i <= Math.min(nums.length - 1, idx + nums[idx]); i++) {
                tempSum--;
                if (nums[i] == 0) continue;
                int tempReach = nums[i] + i;
                if (maxReach < tempReach) {
                    maxReach = tempReach;
                    maxIdx = i;
                }
            }
            count++;
            if (maxReach >= nums.length - 1) {
                count++;
                break;
            }
            idx = maxIdx;
        }
        return count;
    }
}