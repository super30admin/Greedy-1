Time Complexity (TC): O(n), where n is the length of the nums array, as we traverse the array once from end to start.
Space Complexity (SC): O(1), as we use only a constant amount of additional space.

class Solution {
    public boolean canJump(int[] nums) {
        // Greedy approach
        // Check if we can reach an index or not. If yes, update the previous index.

        int prevIdx = nums.length - 1;

        // Traverse the array from the second last index to the beginning
        for (int i = nums.length - 2; i >= 0; i--) {
            // If the current index can reach or pass the previous index
            if (i + nums[i] >= prevIdx) {
                prevIdx = i;
            }
        }

        // If we can reach the start of the array, return true
        return prevIdx == 0;
    }
}
