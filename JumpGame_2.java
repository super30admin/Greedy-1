// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
	/* In this approach the jumps are starting from the 0th index.
	 * MAximum of the next interval and the nums[i] + i is identified to get the optimal number of jumps to reach the destination.
	 */
public class JumpGame_2 {
	public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int jump = 1;
        int currInterval = nums[0];
        int nextInterval = nums[0];
        for(int i = 1; i < nums.length; i++){
            nextInterval = Math.max(nextInterval, nums[i] + i);
            if(i < nums.length-1 && currInterval == i){
                currInterval = nextInterval;
                jump++;
            }
        }
        return jump;
    }
}
