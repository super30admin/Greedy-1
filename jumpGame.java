// TC: O(N) - traversing the integer array given
// SC: O(1)- constant space
public class jumpGame {

	public boolean JumpGame(int[] nums) {
		
		// consider the last index as the position that we need to reach
		int pos = nums.length-1;
		// we will keep check from the last but one index that if we can reach the last index
		for(int i=nums.length-2;i>=0;i--) {
			// if the current position can be reached by last but one index, we know that we can reach future indices by adding both the
			// number and its index, we can jump to that far index, once we find any index that is greater than  curr last index, we update position
			// so that we can move backwards and check if we reach index 0;
			if(pos <= nums[i]+i) {
				pos = i;
			}
		}
		// we started from last index, we need to check if we are reaching first index to see if we have found our path
		return pos == 0;
	}
	
	public static void main(String[] args) {
		
		jumpGame jg = new jumpGame();
		int[] nums= {2,3,1,1,4};
		System.out.println(jg.JumpGame(nums));
	}
}
