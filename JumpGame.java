// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) return true;

        int destination = nums.length - 1;

        for(int i = destination - 1; i >= 0; i--) {
        	if(i + nums[i] >= destination) {
        		destination = i;
        	}
        }

        return destination == 0;
    }
}