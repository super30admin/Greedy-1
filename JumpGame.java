// Time Complexity: O(n^2) in the worst case
//   - For each index, you may recursively explore up to nums[i] next positions.
//   - Without memoization, this would be exponential. Memoization trims redundant calls.

// Space Complexity: O(n) for the HashSet (memoSet) and recursion stack (call depth).
class Solution {
    public boolean canJump(int[] nums) {
        HashSet<Integer> memoSet = new HashSet<>(); // memoization set to avoid rechecking dead ends
        return dfs(nums, 0, memoSet); // Start DFS from index 0
    }

    private boolean dfs(int[] nums, int idx, HashSet<Integer> memoSet) {
        // Base case: reached the last index
        if (idx == nums.length - 1)
            return true;

        // If we’ve already visited this index and failed, skip it
        if (memoSet.contains(idx))
            return false;

        // Try all possible jump lengths from 1 to nums[idx]
        for (int j = 1; j <= nums[idx]; j++) {
            int newIdx = idx + j;
            // Check if new index is within bounds and leads to the end
            if (newIdx < nums.length && dfs(nums, newIdx, memoSet)) {
                return true;
            }
        }

        // Mark this index as unviable
        memoSet.add(idx);
        return false;
    }
}
