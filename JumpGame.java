// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
	/* In this approach the jumps are starting from the n-2 index
	 * If the previous indexes can be reached from backward traversal until 0th index, then surely the destination index can be reached from
	 * forward traversal.
	 */
public class JumpGame {
	public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) return true;
        int n = nums.length;
        int destination = n - 1;
        for(int i = n-2; i >= 0; i--){
            if(i + nums[i] >= destination){
                destination = i;
            }
        }
        return destination == 0;
    }
}
